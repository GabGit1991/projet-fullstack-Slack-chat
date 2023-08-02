package com.projetfullstackslackchat.projetfullstackslackchat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    User addRoleToUser(String username, String name);

}
