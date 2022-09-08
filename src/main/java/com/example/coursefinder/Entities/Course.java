package com.example.coursefinder.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "course")
public class Course {

    @Getter
    @Setter
    @Id
    private String id;

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

}
