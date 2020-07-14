package com.example.demoh2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ADDRESSES")
@Data
@NoArgsConstructor
public class Address {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(nullable=false)
    private String city;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
