package com.projetfullstackslackchat.projetfullstackslackchat.controller;

import java.util.List;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> antoine
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Canal;
import com.projetfullstackslackchat.projetfullstackslackchat.service.CanalService;

<<<<<<< HEAD


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

    
=======
@RestController
@RequestMapping("canals")
public class CanalController {

	@Autowired
	CanalService canalService;

	@GetMapping
	public List<Canal> getAllCanals() {
		return canalService.getAllCanals();
	}

	@GetMapping("{id}")
	public ResponseEntity getCanalById(@PathVariable("id") Integer id) {
		Optional<Canal> optionalCanal = canalService.getCanalById(id);
		if (optionalCanal.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Canal canalFound = optionalCanal.get();
			return ResponseEntity.ok().body(canalFound);
		}
	}

	@PostMapping("")
	public void addCanal(@RequestBody Canal newCanal) {
		canalService.addCanal(newCanal);
	}

	@DeleteMapping("{id}")
	public ResponseEntity deleteCanalById(@PathVariable("id") Integer id) {
		Boolean isDeleted = canalService.deleteCanalById(id);
		if (isDeleted) {
			return ResponseEntity.ok("Canal bien supprimé");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}")
	public ResponseEntity updateCanalbById(@PathVariable("id") Integer id, @RequestBody Canal canal) {
		Boolean isUpdated = canalService.updateCanalById(id, canal);
		if (isUpdated) {
			return ResponseEntity.ok().body(canal);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

>>>>>>> antoine
}
