package com.application.spring;

import com.application.spring.models.User;
import com.application.spring.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableMongoAuditing
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository repository) {

        Object[][] data = {
                {"Kevin", 23, "Just a modest man", 00000000},
                {"Kauan", 10, "Minecraft", 11111111},
                {"Kiara", 8, "Happy dog", 010101011}
        };

        return args -> {
            repository
                    .deleteAll()
                    .thenMany(
                            Flux
                                    .just(data)
                                    .map(array -> {
                                        return new User((String) array[0], (Number) array[1], (String) array[2], (Number) array[3]);
                                    })
                                    .flatMap(repository::save)
                    )
                    .thenMany(repository.findAll())
                    .subscribe(user -> System.out.println("saving " + user.toString()));

        };
    }

}
