package com.example.SimpleAPI;

import java.time.LocalDate;
import java.util.List;

import com.example.student.Student;
import com.example.student.StudentController;
import com.example.student.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.example.student")
@ComponentScan(basePackageClasses = StudentController.class)
@EntityScan(basePackageClasses = Student.class)
@EnableJpaRepositories(basePackageClasses = StudentRepository.class)
public class SimpleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApiApplication.class, args);
	}
	

}
