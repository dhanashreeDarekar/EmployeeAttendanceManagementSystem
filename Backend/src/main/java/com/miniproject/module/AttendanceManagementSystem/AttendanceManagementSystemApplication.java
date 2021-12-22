package com.miniproject.module.AttendanceManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.miniproject.module.AttendanceManagementSystem.Entity")
@EnableJpaRepositories("com.miniproject.module.AttendanceManagementSystem.Repository_Cls")
//@ComponentScan("Repository_Cls")
public class AttendanceManagementSystemApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
	}

}
