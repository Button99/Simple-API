package com.example.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses= StudentRepository.class)
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student test= new Student(1L, "Chris",
						LocalDate.of(2000, 1, 1), "chriskoubis@hotmail.com");
		
			Student test2= new Student(2L, "Test",
					LocalDate.of(2000, 1, 1), "Test222@hotmail.com");
			
			repository.saveAll(List.of(test, test2));
		};
	}
}
