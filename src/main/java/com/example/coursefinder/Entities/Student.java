package com.example.coursefinder.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student")
public class Student {
    @Getter
    @Setter
    @Id
    private String id;

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

    @Override
    public String toString() {
        return "Student name : "
                + this.getName()
                + " Student graduation year : "
                + this.getGradYear();
    }
}
