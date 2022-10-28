package com.cloud.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.os.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
