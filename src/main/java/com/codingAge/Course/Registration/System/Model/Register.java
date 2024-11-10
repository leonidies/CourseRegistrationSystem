package com.codingAge.Course.Registration.System.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Register {
    @Id
    private String userId;
    private List<String> registeredCourseIds=new ArrayList<>();
    public Register(String userId) {
        this.userId = userId;
    }
}
