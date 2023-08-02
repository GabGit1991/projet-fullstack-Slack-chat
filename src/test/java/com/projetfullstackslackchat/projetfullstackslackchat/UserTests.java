//package com.projetfullstackslackchat.projetfullstackslackchat;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
//import com.projetfullstackslackchat.projetfullstackslackchat.service.UserService;
//
//@SpringBootTest
//public class UserTests {
//
//	@Autowired
//	UserService userService;
//
//	@Test
//	public void testAddUser() {
//		// ARRANGE
//		User user = new User("Billy Boy", "johndoe", "john@example.com", "password");
//		// ACT + ASSERT >> check into database if user has been created
//		Assertions.assertTrue(userService.addUser(user));
//
//	}
//
//	@Test
//	public void testGetAllUsers() {
//		// ARRANGE
//		// ACT
//		List<User> users = userService.getAllUsers();
//		// ASSERT >> Replace the int with the number of elements in the database
//		Assertions.assertEquals(5, users.size());
//	}
//
//	@Test
//	public void testGetUserById() {
//		// ARRANGE
//		Optional<User> userOptional = userService.getUserById(5);
//		Assertions.assertTrue(userOptional.isPresent());
//		User user = userOptional.get();
//		// ASSERT >> check the name of a known element by ID
//		Assertions.assertEquals("Titi", user.getName());
//	}
//
//	@Test
//	public void testDeleteUserById() {
//		Assertions.assertTrue(userService.deleteUserById(1));
//	}
//
//	@Test
//	public void testUpdateUserById() {
//		// ARRANGE >> creation of a new User
//		User updatedUser = new User("Bobby", "jean85", "jeannot@example.com", "jeannotpassword");
//		updatedUser.setId(6); // Artificial implementation of the user's id
//		// ACT >> update of a know existing element
//		userService.updateUserById(6, updatedUser);
//		User userToCompare = userService.getUserById(6).get();
//		// ASSERT > check that a know
//		Assertions.assertEquals(updatedUser.getName(), userToCompare.getName());
//	}
//}