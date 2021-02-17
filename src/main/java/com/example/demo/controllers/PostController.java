package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Post;
import com.example.demo.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable Integer id)
    {
        return postService.getPostById(id);
    }

    @GetMapping("/posts/user/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id)
    {
        return postService.getPostsByUserId(id);
    }

    @PostMapping("/posts")
    public void addNew(@RequestBody Post post)
    {
        postService.addNew(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Integer id)
    {
        postService.deletePost(id);
    }

}
