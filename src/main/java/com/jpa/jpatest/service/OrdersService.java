package com.jpa.jpatest.service;

import com.jpa.jpatest.code.DeliveryStatus;
import com.jpa.jpatest.entity.User;
import com.jpa.jpatest.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Transactional
    public boolean hasOrderThatDoesNotStart(User user) {

        return ordersRepository.countByUserAndDeliveryStatus(user, DeliveryStatus.WAIT) > 0;
    }

    @Transactional(readOnly = true)
    public boolean hasOrderThatDoesNotStartWithReadOnlyTransactional(User user) {

        return ordersRepository.countByUserAndDeliveryStatus(user, DeliveryStatus.WAIT) > 0;
    }
}
