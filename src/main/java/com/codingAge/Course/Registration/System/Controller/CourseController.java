package com.codingAge.Course.Registration.System.Controller;

import com.codingAge.Course.Registration.System.Model.Course;
import com.codingAge.Course.Registration.System.Service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/listOfAllCourses)")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/gettingCourseById/{courseId}")
    public Course getCourseById(@PathVariable String courseId) {
        return courseService.getCourseById(courseId);
    }


    @PostMapping("/creatingCourse")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }


    @PutMapping("/editCourseDetail/{courseId}")
    public Course updateCourse(@PathVariable String courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }


    @DeleteMapping("/deleteCourseById/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
