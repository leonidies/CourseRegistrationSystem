package com.codingAge.Course.Registration.System.Service;

import com.codingAge.Course.Registration.System.Model.Course;
import com.codingAge.Course.Registration.System.Model.Register;
import com.codingAge.Course.Registration.System.Repository.CourseRepository;
import com.codingAge.Course.Registration.System.Repository.RegisterRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public boolean registerForCourse(String userId, String courseId) {
        // Find the registration record for the user
        Register register = registerRepository.findById(userId).orElse(new Register(userId));

        // Check if the course is already registered
        if (register.getRegisteredCourseIds().contains(courseId)) {
            return false; // Already registered
        }

        // Add course and save
        register.getRegisteredCourseIds().add(courseId);
        registerRepository.save(register);
        return true;
    }

    public boolean deregisterFromCourse(String userId, String courseId) {
        // Find the registration record for the user
        Register register = registerRepository.findById(userId).orElse(null);
        if (register == null || !register.getRegisteredCourseIds().contains(courseId)) {
            return false; // Not registered
        }
        // Remove course and save
        register.getRegisteredCourseIds().remove(courseId);
        registerRepository.save(register);
        return true;
    }

    public List<Course> getRegisteredCourses(String userId) {
        // Find the registration record for the user
        Register register = registerRepository.findById(userId).orElse(null);
        if (register == null) {
            return Collections.emptyList(); // No registered courses
        }
        // Find all courses by the list of registered course IDs
        return courseRepository.findAllById(register.getRegisteredCourseIds());
    }

}
