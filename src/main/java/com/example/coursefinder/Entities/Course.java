package com.example.coursefinder.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Course {
    @Getter
    @Setter
    @Size(min = 3, max = 3, message
            = "{courseCodeSize}")
    private String code;

    @Getter
    @Setter
    @NotNull(message = "{courseNameNotNull}")
    @NotBlank(message = "{courseNameNotEmpty}")
    private String name;

    final String Collegue_name = "FCISASU";

    public Course() {}

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
