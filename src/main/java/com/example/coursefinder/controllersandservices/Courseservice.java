package com.example.coursefinder.controllersandservices;

import com.example.coursefinder.Entities.Course;
import com.example.coursefinder.Repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Courseservice {
    @Autowired
    CourseRepo courseRepo;

    Courseservice(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }
//    private List<Course> courses = new ArrayList<>(Arrays.asList(
//            new Course("C01","firstCourse"),
//            new Course("C02","secondCourse"),
//            new Course("C03","thirdCourse")));
    List<Course> getallcourses(){

        //return courses;
        return courseRepo.findAll();
    }

    public Course getcourse(String code) {
        //return courses.stream().filter( p -> code.equals(p.getCode())).findFirst().get();

        return courseRepo.findById(code).orElse(new Course());
    }
    public void addcourse(Course course) {
        //courses.add(course);
        courseRepo.save(course);
    }

    public void updateCourse(Course addedcourse, String id) {
//        for (int i = 0 ; i<courses.size() ; i++){
//            if(id.equals(courses.get(i).getCode())){
//                courses.set(i,addedcourse);
//                return;
//            }
//        }
        courseRepo.save(addedcourse);

    }

    public void deleteCourse(String id) {
        //courses.removeIf(p->id.equals(p.getCode()));
        courseRepo.deleteById(id);
    }


}
