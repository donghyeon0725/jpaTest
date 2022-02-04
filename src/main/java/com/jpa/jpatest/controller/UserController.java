package com.jpa.jpatest.controller;

import com.jpa.jpatest.entity.User;
import com.jpa.jpatest.repository.UserRepository;
import com.jpa.jpatest.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final OrdersService ordersService;

    private final EntityManager entityManager;

    // 트랜잭션을 열지 않은 경우
    @GetMapping("/my1/{userId}")
    public Map getMyInfo1(@PathVariable Long userId) {
        Map<String, Object> info = new HashMap<>();


        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저가 없습니다."));
        user.setProfileUrl("https://test.com/" + user.getProfileUrl());

        System.out.println("영속성 컨텍스트에서 관리중인가? => " + entityManager.contains(user));

        info.put("user", user);

        return info;
    }

    // 트랜잭션을 연 경우
    @GetMapping("/my2/{userId}")
    public Map getMyInfo2(@PathVariable Long userId) {
        Map<String, Object> info = new HashMap<>();


        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저가 없습니다."));
        user.setProfileUrl("https://test.com/" + user.getProfileUrl());

        System.out.println("영속성 컨텍스트에서 관리중인가? => " + entityManager.contains(user));

        info.put("user", user);
        info.put("hasOrderThatDoesNotStart", ordersService.hasOrderThatDoesNotStart(user));

        return info;
    }

    // readonly 트랜잭션을 연 경우
    @GetMapping("/my3/{userId}")
    public Map getMyInfo3(@PathVariable Long userId) {
        Map<String, Object> info = new HashMap<>();


        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저가 없습니다."));
        user.setProfileUrl("https://test.com/" + user.getProfileUrl());

        System.out.println("영속성 컨텍스트에서 관리중인가? => " + entityManager.contains(user));

        info.put("user", user);
        info.put("hasOrderThatDoesNotStart", ordersService.hasOrderThatDoesNotStartWithReadOnlyTransactional(user));

        return info;
    }

    // 영속성
    @GetMapping("/my4/{userId}")
    public Map getMyInfo4(@PathVariable Long userId) {
        Map<String, Object> info = new HashMap<>();


        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("유저가 없습니다."));
        entityManager.detach(user);

        User returnUser = new User();
        returnUser.setProfileUrl("https://test.com/" + user.getProfileUrl());
        System.out.println("영속성 컨텍스트에서 관리중인가? => " + entityManager.contains(returnUser));
        BeanUtils.copyProperties(user, returnUser);

        info.put("user", returnUser);
        info.put("hasOrderThatDoesNotStart", ordersService.hasOrderThatDoesNotStart(user));

        return info;
    }

}
