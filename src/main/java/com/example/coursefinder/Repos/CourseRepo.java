package com.example.coursefinder.Repos;

import com.example.coursefinder.Entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepo extends MongoRepository<Course,String> {

}
