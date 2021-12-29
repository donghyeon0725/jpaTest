package com.jpa.jpatest.repository;

import com.jpa.jpatest.code.DeliveryStatus;
import com.jpa.jpatest.entity.Orders;
import com.jpa.jpatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    int countByUserAndDeliveryStatus(User user, DeliveryStatus deliveryStatus);
}
