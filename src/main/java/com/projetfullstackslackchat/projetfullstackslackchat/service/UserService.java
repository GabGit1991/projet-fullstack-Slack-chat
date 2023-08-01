package com.projetfullstackslackchat.projetfullstackslackchat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
import com.projetfullstackslackchat.projetfullstackslackchat.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * METHOD TO CREATE NEW USER
	 * 
	 * @param user
	 * @return we save the User in the database
	 */
	public Boolean addUser(User user) {
		// check that the User in paramater is correctly implemented
		if (user.getName() != null) {
			userRepository.save(user);
			return true;
		}
		// if it's not the cas, we return false
		return false;

	}

	/**
	 * METHOD TO GET THE LIST OF ALL USERS IN DATABASE
	 * 
	 * @return the list of all User entities of the detabase
	 */
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * METHOD TO FIND A USER BY ITS ID
	 * 
	 * @param id
	 * @return an Optional Entity containing a User in function of their id if it
	 *         exists.
	 */
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	/**
	 * METHOD TO DELETE A USER BY ITS ID
	 * 
	 * @param id
	 * @return a Boolean that indicates if a User has been correctly deleted
	 */
	public Boolean deleteUserById(Integer id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * METHOD TO UPDATE A USER BY ITS ID AND A NEW USER
	 * 
	 * @param id
	 * @return a Boolean that indicates if a User has been correctly deleted
	 */
	public Boolean updateUserById(Integer id, User user) {
		Optional<User> optionalUser = userRepository.findById(id);
		// we check that the User exists and that the id entered match the user's id.
		if (optionalUser.isPresent() && id == user.getId()) {
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

}
