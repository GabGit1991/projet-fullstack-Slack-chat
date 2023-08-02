package com.projetfullstackslackchat.projetfullstackslackchat.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
import com.projetfullstackslackchat.projetfullstackslackchat.entity.UserRole;
import com.projetfullstackslackchat.projetfullstackslackchat.repository.UserRepository;
import com.projetfullstackslackchat.projetfullstackslackchat.repository.UserRoleRepository;

import jakarta.annotation.PostConstruct;

@Transactional // permet de passer en mode transaction, chaque methode de la class est affecté
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// ajout pour Spring Security -> hachage password
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	// ajout pour Spring security -> gestion des roles (USER/ADMIN)
	@Autowired
	UserRoleRepository userRoleRepository;

	/**
	 * METHOD TO CREATE NEW USER
	 * 
	 * @param user
	 * @return we save the User in the database
	 */
	public Boolean addUser(User user) {
		// check that the User in paramater is correctly implemented
		if (user.getName() != null) {

			if (userRepository.existsByUsername(user.getUserName())) {
				throw new IllegalArgumentException("le nom d'utilisateur est déja utilisé");
			}

			if (!isValidEmail(user.getEmail())) {
				throw new IllegalArgumentException("Email invalide");
			}

			// on prend le password actuel du user et on l'encode, puis on sauvegarde ce
			// nouveau password
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			// on applique par defaut un userRole USER a la création d'un user
			Optional<UserRole> role = userRoleRepository.findByName("USER");
			Set<UserRole> roles = new HashSet<>();
			roles.add(role.get());
			user.setRoles(roles);
			userRepository.save(user);

			return true;
		}
		return false;
	}

	private boolean isValidEmail(String email) {
		return email.contains("@");
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

	public User addRoleToUser(String username, String rolename) {
		Optional<User> user = userRepository.findByUsername(username);
		Optional<UserRole> role = userRoleRepository.findByName(rolename);

		if (user.isPresent() && role.isPresent()) {
			user.get().getRoles().add(role.get()); // on recupere les role deja présent sur le user puis on ajouter le
													// nouveau role
		}

		return null;
	}

	public UserRole createRoles(UserRole role) {
		return userRoleRepository.addRole(role);
	}

	@PostConstruct
	public void initAdminAndUser() {
		createRoles(new UserRole("ADMIN"));
		createRoles(new UserRole("USER"));

		addUser(new User("Tony", "TonyAdmin", "admin@gmail.com", "1234"));
		addUser(new User("Antoine", "AntoineUser", "user@gmail.com", "1234"));

		// user full access
		addRoleToUser("TonyAdmin", "ADMIN");
		addRoleToUser("TonyAdmin", "USER");
		// useer restricted access
		addRoleToUser("AntoineUser", "USER");
	}

    public Optional <User> findByUsername(String username) {
		return userRepository.findByUsername(username);
    }

}
