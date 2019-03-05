package com.application.spring.services;

import com.application.spring.models.User;
import com.application.spring.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {
        logger.info("Add user");
        return userRepository.save(user);
    }

    public Flux<User> findAllUsers() {
        logger.info("Find all users");
        return userRepository.findAll();
    }
}
