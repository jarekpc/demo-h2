package com.example.demoh2.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ITEMS")
@NoArgsConstructor
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
