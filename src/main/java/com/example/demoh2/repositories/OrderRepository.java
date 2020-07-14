package com.example.demoh2.repositories;

import com.example.demoh2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jazy
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
