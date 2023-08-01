//package com.projetfullstackslackchat.projetfullstackslackchat;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import entity.User;
//import repository.UserRepository;
//import service.UserService;
//
//@SpringBootTest
//public class ProjetfullstackslackchatApplicationTests {
//
//	@Autowired
//	private com.projetfullstackslackchat.projetfullstackslackchat.service.UserService user
//
//	@MockBean
//	private UserRepository userRepository;
//
//	@BeforeEach
//	public void setUp() {
//		// Configuration des mocks si nécessaire
//		// Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(new
//		// User("John Doe", "johndoe", "john@example.com", "password")));
//		// Mockito.when(userRepository.findAll()).thenReturn(List.of(new User("John
//		// Doe", "johndoe", "john@example.com", "password")));
//		// Mockito.when(userRepository.save(any(User.class))).thenAnswer(invocation ->
//		// invocation.getArgument(0));
//		// Mockito.when(userRepository.deleteById(1)).thenReturn(null);
//	}
//
//	@Test
//	public void testAddUser() {
//		User user = new User("John Doe", "johndoe", "john@example.com", "password");
//		assertTrue(userService.addUser(user));
//	}
//
//	@Test
//	public void testGetAllUsers() {
//		// Configurez les mocks pour simuler le comportement du repository si nécessaire
//		// Mockito.when(userRepository.findAll()).thenReturn(List.of(new User("John
//		// Doe", "johndoe", "john@example.com", "password")));
//
//		List<User> users = userService.getAllUsers();
//		assertEquals(1, users.size()); // Remplacez le 1 par le nombre attendu d'utilisateurs dans la liste
//	}
//
//	@Test
//	public void testGetUserById() {
//		// Configurez les mocks pour simuler le comportement du repository si nécessaire
//		// Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(new
//		// User("John Doe", "johndoe", "john@example.com", "password")));
//
//		Optional<User> userOptional = userService.getUserById(1);
//		assertTrue(userOptional.isPresent());
//		User user = userOptional.get();
//		assertEquals("John Doe", user.getName());
//	}
//
//	@Test
//	public void testDeleteUserById() {
//		// Configurez les mocks pour simuler le comportement du repository si nécessaire
//		// Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(new
//		// User("John Doe", "johndoe", "john@example.com", "password")));
//
//		assertTrue(userService.deleteUserById(1));
//	}
//
//	@Test
//	public void testUpdateUserById() {
//		User updatedUser = new User("Updated John Doe", "updatedjohndoe", "updatedjohn@example.com", "updatedpassword");
//		// Configurez les mocks pour simuler le comportement du repository si nécessaire
//		// Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(new
//		// User("John Doe", "johndoe", "john@example.com", "password")));
//
//		assertTrue(userService.updateUserById(1, updatedUser));
//	}
//}