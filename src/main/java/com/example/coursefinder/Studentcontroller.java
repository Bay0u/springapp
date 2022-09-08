package com.example.coursefinder;

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
    private Courseservice ourservice;

    @RequestMapping("/students")
    public List<Course> getallstudents(){

        return ourservice.getallcourses();
    }
    @RequestMapping("/students/{code}")
    public Course getstudentbyid(@PathVariable String code){
        return ourservice.getcourse(code);
    }

    @RequestMapping(method= RequestMethod.POST,value="/students")
    public ResponseEntity<Object> addstudent (@RequestBody @Valid Course newcourse , Errors errors){
        if(errors.hasErrors()){
            String errorMessage = "";
            for (int i = 0 ; i< errors.getErrorCount() ; i++){
                errorMessage = errorMessage + "" + errors.getAllErrors().get(i).getDefaultMessage()+" ";
            }
            return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
        }

        ourservice.addcourse(newcourse);
        return new ResponseEntity<>(newcourse.toString(), HttpStatus.OK);

    }

    @RequestMapping(method= RequestMethod.PUT,value="/students/{code}")
    public void updatestudent (@RequestBody Course addedcourse , @PathVariable String code){
        ourservice.updateCourse(addedcourse,code);
    }
    @RequestMapping(method= RequestMethod.DELETE,value="/students/{code}")
    public void deletestudent(@PathVariable String code){
        ourservice.deleteCourse(code);
    }



}
