package com.example.coursefinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

@Service
public class Courseservice {
    @Autowired
    CourseRepo courseRepo;

    Courseservice(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }
    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("C01","firstCourse"),
            new Course("C02","secondCourse"),
            new Course("C03","thirdCourse")));
    List<Course> getallcourses(){

        return courses;
    }

    public Course getcourse(String code) {
        return courses.stream().filter( p -> code.equals(p.getCode())).findFirst().get();
    }
    public void addcourse(Course course) {
        courses.add(course);
        courseRepo.save(course);
    }

    public void updateCourse(Course addedcourse, String id) {
        for (int i = 0 ; i<courses.size() ; i++){
            if(id.equals(courses.get(i).getCode())){
                courses.set(i,addedcourse);
                return;
            }
        }
    }

    public void deleteCourse(String id) {
        courses.removeIf(p->id.equals(p.getCode()));
    }


}
