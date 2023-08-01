package com.projetfullstackslackchat.projetfullstackslackchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.Canal;


@Repository
public interface CanalRepository extends JpaRepository<Canal,Integer>{
    
}
