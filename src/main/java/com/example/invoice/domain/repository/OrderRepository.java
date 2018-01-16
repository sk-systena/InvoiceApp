package com.example.invoice.domain.repository;

import com.example.invoice.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kesuzuki
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
