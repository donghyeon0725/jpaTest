package com.jpa.jpatest.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String name;

    private String profileUrl;

    private Integer age = 0;
}
