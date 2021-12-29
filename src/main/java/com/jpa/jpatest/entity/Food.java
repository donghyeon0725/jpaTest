package com.jpa.jpatest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Food {
    @Id
    @GeneratedValue
    private Long foodId;

    private String name;

    private Integer price;

}
