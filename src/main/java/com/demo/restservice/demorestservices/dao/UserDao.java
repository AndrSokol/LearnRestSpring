package com.demo.restservice.demorestservices.dao;

import com.demo.restservice.demorestservices.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {

    private static List<User> userList;
    int userCount = 3;

    static {
        userList = new ArrayList<>();

        User user1 = new User(1, "Vasja", new Date());
        User user2 = new User(2, "Petja", new Date());
        User user3 = new User(3, "Misha", new Date());

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public List<User> findAll() {
        return userList;
    }

    public User findOne(Integer id){
        return findById(id);
    }

    public void removeUser(User user){
        userList.remove(user);
    }

    public User save(User user) {
        if(user.getId() == null){
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    private User findById(Integer id) {
        User user = null;

        for(User u : userList){
            if(u.getId().equals(id)){
                user = u;
            }
        }

        return user;
    }
}
