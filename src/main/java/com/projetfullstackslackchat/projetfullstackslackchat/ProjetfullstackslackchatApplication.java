package com.projetfullstackslackchat.projetfullstackslackchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetfullstackslackchat.projetfullstackslackchat.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ProjetfullstackslackchatApplication {


	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetfullstackslackchatApplication.class, args);
	}

	@PostConstruct
	void populateUsers(){
		userService.initAdminAndUser();
	}

}
