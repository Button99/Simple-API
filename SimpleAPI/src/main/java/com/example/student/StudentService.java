package com.example.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository= studentRepository;
	}
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("Email is taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("Student does not exists!");
		}

		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void update(Long studentId, String name, String email) {

		Student student= studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
				"Student does not exists!"
		));

		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if(email != null && email.length() > 10 && !Objects.equals(student.getEmail(), email)) {
			student.setEmail(email);
		}
	}
}
