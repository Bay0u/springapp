package com.example.coursefinder.Repos;

import com.example.coursefinder.Entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student,String> {
    Student findStudentByEmail(String email);
    Student findStudentByName(String name);
}
