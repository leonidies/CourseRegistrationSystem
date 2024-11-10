package com.codingAge.Course.Registration.System.Controller;

import com.codingAge.Course.Registration.System.Model.Course;
import com.codingAge.Course.Registration.System.Model.Register;
import com.codingAge.Course.Registration.System.Service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerForCourse(@RequestBody Map<String, String> requestData) {
        String userId = requestData.get("userId");
        String courseId = requestData.get("courseId");

        boolean isRegistered = registerService.registerForCourse(userId, courseId);
        if (isRegistered) {
            return ResponseEntity.ok("Registration successful!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already registered for this course.");
        }
    }

    @DeleteMapping("/deregister")
    public ResponseEntity<?> deregisterFromCourse(@RequestParam String userId, @RequestParam String courseId) {
        boolean isDeregistered = registerService.deregisterFromCourse(userId, courseId);
        if (isDeregistered) {
            return ResponseEntity.ok("Deregistration successful!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not registered for this course.");
        }
    }

    @GetMapping("/registeredCourses")
    public ResponseEntity<List<Course>> getRegisteredCourses(@RequestParam String userId) {
        List<Course> courses = registerService.getRegisteredCourses(userId);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/allCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = registerService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

}
