package com.example.demoh2;

import com.example.demoh2.entity.User;
import com.example.demoh2.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoH2ApplicationTests {

    @Autowired
    private UserRepository userRepository;


   @Disabled
    @Order(1)
    public void findAllUsers(){
        List<User> users = userRepository.findAll();
        System.out.println(users.size());
        assertNotNull(users);
//        assertTrue(users.isEmpty());
    }


    @Disabled
    @Order(2)
    public void findByUserId(){
        Optional<User> user = userRepository.findById(1);
        assertTrue(user.isEmpty());
    }


    @Disabled
//    @Order(3)
    public void saveUser(){
//        Address address = new Address();
//        Set<Address> addressSet = new HashSet<>();
//        addressSet.add(address);
//        User user = new User(1, "Adam","adam@o2.pl", LocalDate.now(), true, addressSet);
//        User save = userRepository.save(user);
//        User newUser = userRepository.findById(1).get();
//        assertNotNull(newUser);
//        assertEquals("Adam", newUser.getName());
    }

//    @Test
//    void contextLoads() {
//    }

}
