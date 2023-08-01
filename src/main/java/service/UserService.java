package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import entity.User;
import repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * 
	 * @param user
	 * @return on sauve l'utilisateur dans la base de données
	 */
	public Boolean createUser(User user) {
		// on vérifier que l'user rentré en paramètre a des attributs cohérents
		if (user.getName() != null) {
			userRepository.save(user);
			return true;
		}
		// si ce n'est pas le cas, on retourne false
		return false;

	}

	/**
	 * 
	 * @return la liste de tous les utilisateurs présents en base de données
	 */
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * 
	 */
	public ResponseEntity findUserById(Integer id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {

		}

	}
}
