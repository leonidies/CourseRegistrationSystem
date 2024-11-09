package com.codingAge.Course.Registration.System.Service;

import com.codingAge.Course.Registration.System.Model.Course;
import com.codingAge.Course.Registration.System.Repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(String courseId, Course updatedCourse) {
        if (courseRepository.existsById(courseId)) {
            updatedCourse.setCourseId(courseId);  // Ensure the ID is correct
            return courseRepository.save(updatedCourse);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course with ID " + courseId + " does not exist");
        }
    }

    public void deleteCourse(String courseId) {
        courseRepository.deleteById(courseId);
    }

}
