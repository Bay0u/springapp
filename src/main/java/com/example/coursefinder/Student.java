package com.example.coursefinder;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;

public class Student {
    @Getter
    @Setter
    @NotNull(message = "{studentNameNotNull}")
    @NotBlank(message = "{studentNameNotEmpty}")
    private String name;

    @Getter
    @Setter
    @NotEmpty(message = "{coursesArrayNotEmpty}")
    private ArrayList<Course> courses;

    @Getter
    @Setter
    @Min(value = 2022, message = "{gradYearNotOver}")
    @Max(value = 2027, message = "{gradYearNotOver}")
    private short gradYear;

    @Getter
    @Setter
    @PastOrPresent(message = "{enrollmentDateError}")
    private Date enrollmentDate;

    @Getter
    @Setter
    @Email(message = "{emailError}")
    private String email;

    @Getter
    @Setter
    @Size(min = 11, max = 13, message
            = "{mobileNumberError}")
    private String mobilenNumber;

    @Getter
    @Setter
    @AssertTrue (message = "{graduatedError}")
    private boolean undergraduate;
    public Student(){}

    public Student(String name, ArrayList<Course> courses, short gradYear, Date enrollmentDate, String email, String mobilenNumber, boolean undergraduate) {
        this.name = name;
        this.courses = courses;
        this.gradYear = gradYear;
        this.enrollmentDate = enrollmentDate;
        this.email = email;
        this.mobilenNumber = mobilenNumber;
        this.undergraduate = undergraduate;
    }

    @Override
    public String toString() {
        return "Student name : "
                + this.getName()
                + " Student graduation year : "
                + this.getGradYear();
    }
}
