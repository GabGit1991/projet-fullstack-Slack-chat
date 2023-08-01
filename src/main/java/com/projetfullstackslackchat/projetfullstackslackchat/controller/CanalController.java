package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.CanalService;

@RestController
@RequestMapping("/canals")
public class CanalController {

    @Autowired
    CanalService canalService;

    @GetMapping

    
}
