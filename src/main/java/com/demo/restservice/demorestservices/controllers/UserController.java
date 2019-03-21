package com.demo.restservice.demorestservices.controllers;

import com.demo.restservice.demorestservices.models.Post;
import com.demo.restservice.demorestservices.models.User;
import com.demo.restservice.demorestservices.services.PostService;
import com.demo.restservice.demorestservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    PostService postService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.retrieveAllUsers();
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getAllUsersPost(@PathVariable int id){
        User user = service.retrieveById(id);
        return user.getPosts();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getById(@PathVariable Integer id){
        User user = service.retrieveById(id);
        EntityModel<User> model = new EntityModel<User>(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
        model.add(linkTo.withRel("all-users"));
        return model;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Integer id){
        service.removeById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){

        User savedUser =  service.create(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post){

        User user = service.retrieveById(id);

        Post savedPost = postService.create(user, post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
