package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id)
    {
        Optional<User> userById = userService.getUserById(id);
        if(userById.isPresent())
        {
            return userById.get().getPosts();
        }
        return null;
    }

    @GetMapping("/users/location/{id}/users")
    public List<User> getUsersByLocationId(@PathVariable Integer id)
    {
        return userService.getUsersByLocationId(id);
    }

    @PostMapping("/users")
    public void InsertUser(@RequestBody User user)
    {
        userService.InsertUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void DeleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
    }
}
