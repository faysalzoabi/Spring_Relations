package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	public List<User> getUsersByLocationId(Integer id) {
		return userRepository.findByLocationId(id);
	}

    public void InsertUser(User user)
    {
        userRepository.save(user);
    }

	public void deleteUser(Integer id) {
        userRepository.deleteById(id);
	}

}
