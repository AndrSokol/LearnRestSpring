package com.demo.restservice.demorestservices.controllers;

import com.demo.restservice.demorestservices.models.Post;
import com.demo.restservice.demorestservices.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.retrieveAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.retrievePostById(id);
    }

}
