package com.projetfullstackslackchat.projetfullstackslackchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}