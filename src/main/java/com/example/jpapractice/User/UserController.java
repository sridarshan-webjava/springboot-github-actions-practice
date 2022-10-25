package com.example.jpapractice.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user")
    public ResponseEntity<User> getUserDetailsByEmail(@RequestParam String email){
        return userService.fetchUserByEmail(email);
    }

    @PostMapping("/save-user")
    public ResponseEntity<User> saveUserDetails(@RequestBody User user){
        return userService.insert(user);
    }
}
