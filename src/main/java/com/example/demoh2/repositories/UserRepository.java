package com.example.demoh2.repositories;

import com.example.demoh2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
//
//    User findByNameAndId(String name, Integer id);
//
//    User findUserById(Integer id);

}
