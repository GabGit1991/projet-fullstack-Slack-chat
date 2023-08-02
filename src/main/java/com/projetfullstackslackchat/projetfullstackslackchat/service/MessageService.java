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
	MessageRepository repo;

	public void addMessage(Message message) {
		repo.save(message);
	}

	public List<Message> getMessages() {
		return repo.findAll();
	}

	public Optional<Message> getMessage(Integer id) {
		return repo.findById(id);
	}

	public void updateMessage(Integer id, Message message) {
		repo.save(message);
	}

	public void deleteMessage(int id) {
		repo.deleteById(id);
	}

}