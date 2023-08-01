package com.projetfullstackslackchat.projetfullstackslackchat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Canal;
import com.projetfullstackslackchat.projetfullstackslackchat.repository.CanalRepository;

@Service
public class CanalService {

	@Autowired
	CanalRepository canalRepository;

	public List<Canal> getAllCanals() {
		return canalRepository.findAll();
	}

	public Optional<Canal> getCanalById(Integer id) {
		return canalRepository.findById(id);
	}

	public Boolean deleteCanalById(Integer id) {
		Optional<Canal> foundCanal = canalRepository.findById(id);
		if (foundCanal.isPresent()) {
			canalRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public Boolean updateCanalById(Integer id, Canal canal) {
		Optional<Canal> canalToModify = canalRepository.findById(id);
		// si le canal a modifier est présent
		if (canalToModify.isPresent()) {
			// si le canal a modifier est identique au canal fournis, alors on modife rien
			if (canalToModify.get().equals(canal)) {
				return false;
			}

			Canal canalToSave = canalToModify.get();

			if (canalToModify.get().getCanalName() != canal.getCanalName()) {
				canalToSave.setCanalName(canal.getCanalName());
			}

			if (canalToModify.get().getAssignedMessages() != canal.getAssignedMessages()) {
				canalToSave.setAssignedMessages(canal.getAssignedMessages());
			}

			if (canalToModify.get().getAssignedUsers() != canal.getAssignedUsers()) {
				canalToSave.setAssignedUsers(canal.getAssignedUsers());
			}

			canalRepository.save(canalToSave);
			return true;
		}
		return false;

	}

	public Canal addCanal(Canal canal) {
		canalRepository.save(canal);
		return canal;
	}

}