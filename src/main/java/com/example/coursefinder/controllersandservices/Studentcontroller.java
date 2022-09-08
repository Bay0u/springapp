package com.example.coursefinder.controllersandservices;

        import com.example.coursefinder.Entities.Student;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.Errors;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.*;
        import java.util.*;

@RestController
public class Studentcontroller {

    @Autowired
    private Studentservice ourservice;

    @RequestMapping("/students")
    public List<Student> getallstudents(){

        return ourservice.getallstudents();
    }
    @RequestMapping("/students/{email}")
    public Student getstudentbyemail(@PathVariable String email){
        return ourservice.getstudent(email);
    }

    @RequestMapping(method= RequestMethod.POST,value="/students")
    public ResponseEntity<Object> addstudent (@RequestBody @Valid Student newstudent , Errors errors){
        if(errors.hasErrors()){
            String errorMessage = "";
            for (int i = 0 ; i< errors.getErrorCount() ; i++){
                errorMessage = errorMessage + "" + errors.getAllErrors().get(i).getDefaultMessage()+" ";
            }
            return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
        }
        ourservice.addstudent(newstudent);
        return new ResponseEntity<>(newstudent.toString(), HttpStatus.OK);

    }

    @RequestMapping(method= RequestMethod.PUT,value="/students/{code}")
    public void updatestudent (@RequestBody Student addedstudent , @PathVariable String code){
        ourservice.updatestudent(addedstudent,code);
    }
    @RequestMapping(method= RequestMethod.DELETE,value="/students/{code}")
    public void deletestudent(@PathVariable String email){
        ourservice.deletestudent(email);
    }



}
