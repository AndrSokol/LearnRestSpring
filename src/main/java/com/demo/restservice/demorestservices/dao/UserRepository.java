package com.demo.restservice.demorestservices.dao;

import com.demo.restservice.demorestservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
