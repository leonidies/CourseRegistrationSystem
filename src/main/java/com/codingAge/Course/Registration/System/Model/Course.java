package com.codingAge.Course.Registration.System.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String description;
    private String courseInstructor;
    private String courseDuration;
    private String prerequisites;

}
