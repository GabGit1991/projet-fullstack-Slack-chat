//package com.projetfullstackslackchat.projetfullstackslackchat;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.projetfullstackslackchat.projetfullstackslackchat.entity.Message;
//import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
//import com.projetfullstackslackchat.projetfullstackslackchat.service.MessageService;
//
//@SpringBootTest
//public class MessageTest {
//
//	@Autowired
//	MessageService messageService;
//
//	@Test
//	public void testAddMessage() {
//		// ARRANGE >> creation of a new User
//		User newUser = new User("Bobby", "jean85", "jeannot@example.com", "jeannotpassword");
//		newUser.setId(6);
//		Message message = new Message(newUser, "Alors peut être ? ");
//		// ACT
//		messageService.addMessage(message);
//		// ASSERT
//	}
//
//	@Test
//	void testGetAllMessages() {
//		// ARRANGE + ACT >> fetch the number of elements in our database
//		List<Message> listMessage = messageService.getAllMessages();
//		Integer nb_element = listMessage.size();
//		// ASSERT >> comparison with the number known
//		Assertions.assertEquals(nb_element, 10);
//
//	}
//
//	@Test
//	void testGetMessagesById() {
//		// ARRANGE + ACT >> get the message with id=11
//		Message messageFound = messageService.getMessageById(11).get();
//		// ASSERT
//		Assertions.assertEquals("La date !", messageFound.getContent());
//
//	}
//
//	@Test
//	void testDeleteMessageById() {
//		// ARRANGE + ACT : fetching the number of elements in the table
//		Integer nbElement = messageService.getAllMessages().size();
//		// Deletion of an element
//		messageService.deleteMessageById(17);
//		Integer newNbElement = messageService.getAllMessages().size();
//		// The previous number of element should now be equal to the new number +1
//		Assertions.assertEquals(nbElement, newNbElement + 1);
//	}
//
//	@Test
//	void testUpdateMessageById() {
//		User newUser = new User("Bobby", "jean85", "jeannot@example.com", "jeannotpassword");
//		newUser.setId(6);
//		Message newMessage = new Message(newUser, "Nouvelle tentative");
//		newMessage.setId(15);
//		messageService.updateMessageById(15, newMessage);
//	}
//
//}
