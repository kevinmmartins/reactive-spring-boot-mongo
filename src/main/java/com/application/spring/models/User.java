package com.application.spring.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class User {
    private String name;
    private Number age;
    private String additionalInfo;
    private Number document;

    public User(String name, Number age, String additionalInfo, Number document) {
        this.name = name;
        this.age = age;
        this.additionalInfo = additionalInfo;
        this.document = document;
    }
}
