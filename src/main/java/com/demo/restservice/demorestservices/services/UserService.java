package com.demo.restservice.demorestservices.services;

import com.demo.restservice.demorestservices.dao.UserDao;
import com.demo.restservice.demorestservices.exceptions.UserNotFoundException;
import com.demo.restservice.demorestservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> retrieveAllUsers(){
        return userDao.findAll();
    }

    public User retrieveById(Integer id) {
        return getUser(id);
    }

    public void removeById(Integer id) {
        userDao.removeUser(getUser(id));
    }

    private User getUser(Integer id) {
        User user = userDao.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("User with id %s not found", id));
        }
        return user;
    }

    public User create(User user) {
        return userDao.save(user);
    }
}
