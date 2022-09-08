package com.example.coursefinder.controllersandservices;

        import com.example.coursefinder.Entities.Course;
        import com.example.coursefinder.Entities.Student;
        import com.example.coursefinder.Repos.StudentRepo;
        import lombok.SneakyThrows;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.text.SimpleDateFormat;
        import java.util.*;

@Service
public class Studentservice {
    static ArrayList<Student> Students_Array = new <Student>ArrayList();
    static ArrayList<Course> Courses_Array = new <Course>ArrayList();
    @Autowired
    StudentRepo studentRepo;

    Studentservice(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    List<Student> getallstudents(){

        //return Students_Array;
        return studentRepo.findAll();
    }

    public Student getstudent(String id) {
        //return Students_Array.stream().filter( p -> email.equals(p.getEmail())).findFirst().get();
        return studentRepo.findById(id).orElse(new Student());
    }
    public void addstudent(Student student) {
        //Students_Array.add(student);
        studentRepo.save(student);
    }

    public void updatestudent(Student addedstudent, String email) {
//        for (int i = 0 ; i<Students_Array.size() ; i++){
//            if(email.equals(Students_Array.get(i).getEmail())){
//                Students_Array.set(i,addedstudent);
//                return;
//            }
//        }
        studentRepo.save(addedstudent);
    }

    public void deletestudent(String id) {
        //Students_Array.removeIf(p->email.equals(p.getEmail()));

        studentRepo.delete(getstudent(id));
    }

    @SneakyThrows
    private static void initialize() {

        //Courses Initialization

        Course First_Course = new Course();
        First_Course.setCode("CO1");
        First_Course.setName("first_Course");

        Course Second_Course = new Course();
        Second_Course.setCode("CO2");
        Second_Course.setName("second_Course");

        Course Third_Course = new Course();
        Third_Course.setCode("CO3");
        Third_Course.setName("third_Course");

        //Students Initialization

        Student First_Student = new Student();
        First_Student.setName("firststudentname");
        First_Student.setCourses(new ArrayList<Course>() {
        });
        First_Student.setGradYear((short) 2022);
        First_Student.setEmail("first@gmail.com");
        First_Student.setEnrollmentDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        First_Student.setMobilenNumber("01012345678");
        First_Student.setUndergraduate(true);


        Student Second_Student = new Student();
        Second_Student.setName("secondstudentname");
        Second_Student.setCourses(new ArrayList<Course>() {
        });
        Second_Student.setGradYear((short) 2022);
        Second_Student.setEmail("second@gmail.com");
        Second_Student.setEnrollmentDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        Second_Student.setMobilenNumber("01012345678");
        Second_Student.setUndergraduate(true);

        Student Third_Student = new Student();
        Third_Student.setName("thirdstudentname");
        Third_Student.setCourses(new ArrayList<Course>() {
        });
        Third_Student.setGradYear((short) 2022);
        Third_Student.setEmail("third@gmail.com");
        Third_Student.setEnrollmentDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        Third_Student.setMobilenNumber("01012345678");
        Third_Student.setUndergraduate(true);

        //Students Courses Initialization


        First_Student.getCourses().add(First_Course);
        First_Student.getCourses().add(Second_Course);
        First_Student.getCourses().add(Third_Course);

        Second_Student.getCourses().add(Third_Course);

        Third_Student.getCourses().add(First_Course);

        //Saving the Students and Courses Into Arrays


        Students_Array.add(First_Student);
        Students_Array.add(Second_Student);
        Students_Array.add(Third_Student);

        Courses_Array.add(First_Course);
        Courses_Array.add(Second_Course);
        Courses_Array.add(Third_Course);
    }


}
