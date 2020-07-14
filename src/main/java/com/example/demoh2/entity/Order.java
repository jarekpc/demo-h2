package com.example.demoh2.entity;

import javax.persistence.*;

@Entity
@Table(name ="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, name="cust_name")
    private String customerName;

    @Column(nullable = false, name = "cust_email")
    private String customerEmail;
}
