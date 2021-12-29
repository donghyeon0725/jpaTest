package com.jpa.jpatest;

import com.jpa.jpatest.entity.User;
import com.jpa.jpatest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();

        user.setProfileUrl("my/394943.png");
        user.setAge(12);
        user.setName("이름");

        userRepository.save(user);
    }
}
