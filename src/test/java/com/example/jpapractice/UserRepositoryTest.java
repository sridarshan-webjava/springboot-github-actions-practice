package com.example.jpapractice;

import com.example.jpapractice.User.User;
import com.example.jpapractice.User.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = new User("D","role","d@role.com");
        userRepository.save(user);
    }

    @Test
    public void testIfUsersAreObtainedByEmail(){
        String email = "d@role.com";
        User user = userRepository.getUserByEmail(email);
        assertEquals(user.getEmail(),email);
    }

    @Test
    public void testIfUsersIncorrectUsersAreAccepted(){
        String email = "d@rol.com";
        User user = userRepository.getUserByEmail(email);
        assertNull(user);
    }
}
