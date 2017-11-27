package com.ed.manufacture.service;

import com.ed.manufacture.dao.UserRepository;
import com.ed.manufacture.entity.MaterialGroup;
import com.ed.manufacture.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public void delUser(int id){
        userRepository.delete(id);
    }

    public  Iterable<User> getAuthUsers() {
        return userRepository.getAuthUsers();
    }

    public User getUserById(int id){
        return userRepository.findOne(id);
    }

}
