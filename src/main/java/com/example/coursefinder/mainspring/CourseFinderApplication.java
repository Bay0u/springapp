package com.example.coursefinder.mainspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CourseFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseFinderApplication.class, args);
    }

}
