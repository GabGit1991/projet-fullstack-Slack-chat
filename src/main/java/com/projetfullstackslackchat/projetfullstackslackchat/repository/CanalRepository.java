package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal,Integer>{
    
}
