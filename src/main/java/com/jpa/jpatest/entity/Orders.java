package com.jpa.jpatest.entity;


import com.jpa.jpatest.code.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long ordersId;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
