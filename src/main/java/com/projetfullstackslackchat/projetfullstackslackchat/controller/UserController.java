package com.projetfullstackslackchat.projetfullstackslackchat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
import com.projetfullstackslackchat.projetfullstackslackchat.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAllUSers() {
		return userService.getAllUsers();
	}

	@GetMapping("{id}")
	public ResponseEntity getUserById(@PathVariable("id") Integer id) {
		Optional<User> optionalUser = userService.getUserById(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			User userFound = optionalUser.get();
			return ResponseEntity.ok().body(userFound);
		}
	}

	@PostMapping("")
	public void addNewUser(@RequestBody User newUser) {
		userService.addUser(newUser);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteUserById(@PathVariable("id") Integer id) {
		Boolean isDeleted = userService.deleteUserById(id);
		if (isDeleted) {
			return ResponseEntity.ok("User bien supprimé");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity updateUserbById(@PathVariable("id") Integer id, @RequestBody User user) {
		Boolean isUpdated = userService.updateUserById(id, user);
		if (isUpdated) {
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
