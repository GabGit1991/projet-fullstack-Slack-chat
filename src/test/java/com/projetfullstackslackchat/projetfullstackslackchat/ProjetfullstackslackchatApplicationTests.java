package com.projetfullstackslackchat.projetfullstackslackchat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Canal;
import com.projetfullstackslackchat.projetfullstackslackchat.entity.Message;
import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
import com.projetfullstackslackchat.projetfullstackslackchat.service.CanalService;
import com.projetfullstackslackchat.projetfullstackslackchat.service.MessageService;
import com.projetfullstackslackchat.projetfullstackslackchat.service.UserService;

@SpringBootTest
public class ProjetfullstackslackchatApplicationTests {

    @Autowired
    CanalService canalService;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Test
    void saveCanal() {
        User user1 = new User("nom1", "cat1", "lilo@gmail.com", "stitch");
        User user2 = new User("nom2", "cat2", "cendrillon@gmail.com", "barbieetken");
        userService.addUser(user1); // Re-assigning to the managed entity
        userService.addUser(user2);

        List<User> usersGaming = new ArrayList<>(Arrays.asList(user1, user2));
     

        Message helloDarling = new Message(user2, "hello darling", LocalDateTime.now());
        Message helloMoto = new Message(user1, "Hello motorola", LocalDateTime.now());
        messageService.addMessage(helloMoto);
        messageService.addMessage(helloDarling);

         List<Message> messages = new ArrayList<>(Arrays.asList(helloDarling,helloMoto));
       
        Canal canalGaming = new Canal("canal de gamin", usersGaming, messages);
        canalService.addCanal(canalGaming);

    }

    @Test
    void createCanal() {
        Canal canal = new Canal("pipo");
        canalService.addCanal(null);
    }

    @Test
    void getAllCanals() {
        System.out.println(canalService.getAllCanals());
    }

    @Test
    void getCanalById() {
        System.out.println(canalService.getCanalById(2));
    }

    @Test
    void deleteCanalById() {
        canalService.deleteCanalById(2);
        System.out.println(canalService.getAllCanals());
    }

    @Test
    void updateCanalById() {
        // Optional<Canal> canalupdated =canalService.getCanalById(3);
        // Canal newNameCanal=canalupdated.get();
        // newNameCanal.setCanalName("gaming noobs");
        // canalService.updateCanalById(2, newNameCanal);

        User user1 = new User("nom1", "cat1", "lilo@gmail.com", "stitch");
        User user2 = new User("nom2", "cat2", "cendrillon@gmail.com", "barbieetken");
        User user3 = new User(null, null);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);

        List<User> usersGaming = new ArrayList<>(Arrays.asList(user1, user2));

        Message helloDarling = new Message(user2, "hello darlinbg", LocalDateTime.now());
        Message helloMoto = new Message(user1, "Hello motorola", LocalDateTime.now());
        messageService.addMessage(helloMoto);
        messageService.addMessage(helloDarling);

        List<Message> messages = new ArrayList<>(Arrays.asList(helloDarling, helloMoto));

        Canal newCanal = new Canal("gamin gang", usersGaming, messages);
        canalService.updateCanalById(3, newCanal);
    }

}