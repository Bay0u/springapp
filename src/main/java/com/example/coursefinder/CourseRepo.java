package com.example.coursefinder;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course,String> {

}
