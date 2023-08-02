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

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Message;
import com.projetfullstackslackchat.projetfullstackslackchat.service.MessageService;

@RestController
@RequestMapping("messages")
public class MessageController {

	@Autowired
	MessageService messageService;

	@PostMapping
	public void postMessage(@RequestBody Message newMessage) {
		messageService.addMessage(newMessage);
	}

	@GetMapping
	public List<Message> getAllMessage() {
		return messageService.getAllMessages();
	}

	@GetMapping("{id}")
	public ResponseEntity<Message> getMessageByID(@PathVariable("id") Integer id) {
		Optional<Message> optional = messageService.getMessageById(id);

		if (optional.isPresent()) {
			Message messageFound = optional.get();
			return ResponseEntity.ok(messageFound);
		} else {// if(optional.isEmpty())
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteMessageById(@PathVariable("id") Integer id) {
		if (messageService.deleteMessageById(id)) {
			return ResponseEntity.ok().body("Utilisateur supprimé !");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity putMessage(@PathVariable("id") Integer id, @RequestBody Message message) {

		if (!id.equals(message.getId())) {
			return ResponseEntity.badRequest().build();
		}

		if (messageService.getMessageById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		messageService.updateMessageById(id, message);
		return ResponseEntity.ok().build();
	}

}