package com.example.jpapractice.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

//Repository - Service that connects and interacts with the database
@Service
//Transactional - Meaning that all methods and activities are transactions
//@Transactional
public class UserService {
//    EntityManager - to manage and access the data stored in database
//    @PersistenceContext
//    private EntityManager entityManager;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    Method to insert data into the database
    public ResponseEntity<User> insert(User user){
//        entityManager.persist(user);
        userRepository.save(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    public ResponseEntity<User> fetchUserByEmail(String email){
        User user = userRepository.getUserByEmail(email);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
