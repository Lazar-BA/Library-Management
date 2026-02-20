package com.vujovic.LibManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LibManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibManagementApplication.class, args);
	}

}