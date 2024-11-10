package com.codingAge.Course.Registration.System.Repository;

import com.codingAge.Course.Registration.System.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course,String> {

}
