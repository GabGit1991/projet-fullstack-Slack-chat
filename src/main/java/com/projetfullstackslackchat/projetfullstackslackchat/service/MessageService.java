package com.projetfullstackslackchat.projetfullstackslackchat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Message;
import com.projetfullstackslackchat.projetfullstackslackchat.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	public Message addMessage(Message message) {
		messageRepository.save(message);
		return message;
	}

	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public Optional<Message> getMessageById(Integer id) {
		return messageRepository.findById(id);
	}

	public Boolean updateMessageById(Integer id, Message message) {
		Optional<Message> messageToUpdate = messageRepository.findById(id);
		// si le canal a modifier est présent
		if (messageToUpdate.isPresent()) {
			// si le canal a modifier est identique au canal fournis, alors on modife rien
			if (messageToUpdate.get().equals(message)) {
				return false;
			}

			Message messageToSave = messageToUpdate.get();

			if (messageToUpdate.get().getContent() != message.getContent()) {
				messageToSave.setContent(message.getContent());
			}

			if (messageToUpdate.get().getUser() != message.getUser()) {
				messageToSave.setUser(message.getUser());
			}

			messageRepository.save(messageToSave);
			return true;
		}
		return false;
	}

	public Boolean deleteMessageById(int id) {
		Optional<Message> foundMessage = messageRepository.findById(id);
		if (foundMessage.isPresent()) {
			messageRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
