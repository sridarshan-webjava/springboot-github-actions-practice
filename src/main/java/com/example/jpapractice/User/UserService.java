package com.example.jpapractice.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    Method to insert data into the database
    public ResponseEntity<User> insert(User user){
        userRepository.save(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    public ResponseEntity<User> fetchUserByEmail(String email){
        User user = userRepository.getUserByEmail(email);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
