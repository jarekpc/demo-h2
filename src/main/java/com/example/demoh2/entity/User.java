package com.example.demoh2.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private LocalDate dob;

    private boolean disabled;

//    public User(Integer id, String name, String email, LocalDate dob, boolean disabled)
//    {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.dob = dob;
//        this.disabled = disabled;
//    }

    @OneToMany(mappedBy="user")
    private Set<Address> addresses;
}
