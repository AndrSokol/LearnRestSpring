package com.demo.restservice.demorestservices.dao;

import com.demo.restservice.demorestservices.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
