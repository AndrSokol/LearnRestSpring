package com.demo.restservice.demorestservices.services;

import com.demo.restservice.demorestservices.dao.PostRepository;
import com.demo.restservice.demorestservices.dao.UserDao;
import com.demo.restservice.demorestservices.exceptions.PostNotFoundException;
import com.demo.restservice.demorestservices.models.Post;
import com.demo.restservice.demorestservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post create(User user, Post post) {
//        return userDao.save(user);
        post.setUser(user);
        return postRepository.save(post);
    }

    public List<Post> retrieveAllPosts() {
        return postRepository.findAll();
    }

    public Post retrievePostById(int id) {
        Optional<Post> post = postRepository.findById(id);

        if(! post.isPresent()){
            throw new PostNotFoundException(String.format("Post with id %s not found", id));
        }

        return post.get();
    }
}
