package com.read.appnewsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class AppNewsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppNewsProjectApplication.class, args);
    }

}
