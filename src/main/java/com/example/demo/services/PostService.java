package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Integer id) {
		return postRepository.findById(id);
	}

	public List<Post> getPostsByUserId(Integer id) {
		return postRepository.findByUserId(id);
	}

	public void addNew(Post post) {
		postRepository.save(post);
	}

	public void deletePost(Integer id) {
        postRepository.deleteById(id);
	}

}
