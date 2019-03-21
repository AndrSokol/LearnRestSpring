package com.demo.restservice.demorestservices.services;

import com.demo.restservice.demorestservices.dao.UserDao;
import com.demo.restservice.demorestservices.dao.UserRepository;
import com.demo.restservice.demorestservices.exceptions.UserNotFoundException;
import com.demo.restservice.demorestservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

//    @Autowired
//    UserDao userDao;

    @Autowired
    UserRepository userRepository;

    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    public User retrieveById(Integer id) {
        return getUser(id);
    }

    public void removeById(Integer id) {
//        userDao.removeUser(getUser(id));
        userRepository.deleteById(id);
    }

    private User getUser(Integer id) {
//        User user = userDao.findOne(id);
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException(String.format("User with id %s not found", id));
        }
        return user.get();
    }

    public User create(User user) {
//        return userDao.save(user);
        return userRepository.save(user);
    }
}
