package com.projetfullstackslackchat.projetfullstackslackchat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
     Optional<UserRole> findByName(String name);
     UserRole addRole(UserRole role);
     

}
