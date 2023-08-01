package com.projetfullstackslackchat;

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
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MessageController {
	
	@Autowired
    MessageService annuaire;
	
	@PostMapping("messages")
    public void postMessage(@RequestBody Message newSoigneur){
        annuaire.addMessage(newSoigneur);
    }
	
	@GetMapping("messages")
    public List<Message> getMessageById(){
        return annuaire.getMessages();
    }
	
	@GetMapping("messages/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") Integer id){
        Optional<Message> optional = annuaire.getMessage(id);

        if(optional.isPresent()){
        	Message tigre = optional.get();
            return ResponseEntity.ok(tigre);
        }
        else {//if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }
    

    @DeleteMapping("messages/{id}")
    public void deleteMessage(@PathVariable("id") Integer id){
            annuaire.deleteMessage(id);
    }
    
    @PutMapping("messages/{id}")
    public ResponseEntity putMessage(@PathVariable("id") Integer id, @RequestBody Message message){

        if(!id.equals(message.getId())){
            return ResponseEntity.badRequest().build();
        }

        if(annuaire.getMessage(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        annuaire.updateMessage(id, message);
        return ResponseEntity.ok().build();
    }

}
