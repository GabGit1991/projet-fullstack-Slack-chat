package com.projetfullstackslackchat.projetfullstackslackchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Canal;
import com.projetfullstackslackchat.projetfullstackslackchat.service.CanalService;



@RestController
@RequestMapping("/canals")
public class CanalController {

    @Autowired
    CanalService canalService;

    @GetMapping
    public ResponseEntity getAllCanals(){
        List<Canal> listClients = canalService.getAllCanals();
        return ResponseEntity.ok().body(listClients.toString());
    }

    
}
