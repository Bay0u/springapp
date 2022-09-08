package com.example.coursefinder.controllersandservices;

import com.example.coursefinder.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice ourservice;

    @RequestMapping("/students")
    public List<Student> getallstudents() {

        return ourservice.getallstudents();
    }

    @RequestMapping("/students/{email}")
    public Student getstudentbyid(@PathVariable String id) {
        return ourservice.getstudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public ResponseEntity<Object> addstudent(@RequestBody @Valid Student newstudent, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = "";

            for (int i = 0; i < errors.getErrorCount(); i++) {
                errorMessage = errorMessage + "" + errors.getAllErrors().get(i).getDefaultMessage() + " ";
            }

            return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

        }

        ourservice.addstudent(newstudent);
        return new ResponseEntity<>(newstudent.toString(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{code}")
    public ResponseEntity<String> updatestudent(@RequestBody @Valid Student addedstudent, @PathVariable String code , Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = "";

            for (int i = 0; i < errors.getErrorCount(); i++) {
                errorMessage = errorMessage + "" + errors.getAllErrors().get(i).getDefaultMessage() + " ";
            }

            return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

        }

        ourservice.updatestudent(addedstudent,code);
        return new ResponseEntity<>(addedstudent.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{code}")
    public void deletestudent(@PathVariable String code) {
        ourservice.deletestudent(code);
    }


}
