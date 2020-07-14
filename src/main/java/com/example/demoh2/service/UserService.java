package com.example.demoh2.service;

import com.example.demoh2.entity.User;
import com.example.demoh2.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User findUserId(Integer id) {
//        return userRepository.findUserById(id);
//    }
//
//    public User findNameAndId(String name, Integer id) {
//        return userRepository.findByNameAndId(name, id);
//    }

    @Transactional(transactionManager="userTransactionManager")
    public List<User> allUsers() {
        List<User> all = userRepository.findAll();
        log.info("all users " + all);
        return all;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
