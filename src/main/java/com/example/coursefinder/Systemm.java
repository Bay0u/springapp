package com.example.coursefinder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Systemm {
    static ArrayList<Student> Students_Array = new <Student>ArrayList();

    static ArrayList<Course> Courses_Array = new <Course>ArrayList();
//
//    public static void main(String[] args) {
//        initialize();
//
//        takeTask();
//    }

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

        Student Second_Student = new Student();
        Second_Student.setName("secondstudentname");
        Second_Student.setCourses(new ArrayList<Course>() {
        });
        Second_Student.setGradYear((short) 2022);

        Student Third_Student = new Student();
        Third_Student.setName("thirdstudentname");
        Third_Student.setCourses(new ArrayList<Course>() {
        });
        Third_Student.setGradYear((short) 2022);

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

    static void takeTask() {
        Scanner sc = new Scanner(java.lang.System.in);

        java.lang.System.out.println("Enter Your course code ex: CO1 or CO2 or CO3");

        String Input_Course_Name = sc.nextLine();

        String Validated_Input = inputValidator(Input_Course_Name);

        findCourse(Validated_Input);
    }

    static String inputValidator(String input) {
        if (input.length() == 3) {
            if (input.equals("CO1") || input.equals("CO2") || input.equals("CO3")) {
                return input;
            } else {
                java.lang.System.out.println("Course code not found,Try again");
                takeTask();
            }
        } else {
            java.lang.System.out.println("Please Enter the right code..");
            takeTask();
        }
        return "";
    }

    private static void findCourse(String input) {

        Course course = Courses_Array.stream().filter(p -> input.equals(p.getCode())).findAny().orElse(new Course());

        Students_Array
                .stream()
                .filter(p -> p.getCourses().contains(course))
                .collect(Collectors.toList())
                .forEach((student) -> java.lang.System.out.println(student.toString()));
        //Filtering the students that are taking that course & printing their info

    }
}

