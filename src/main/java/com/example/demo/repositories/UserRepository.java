package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findByLocationId(Integer id);

}
