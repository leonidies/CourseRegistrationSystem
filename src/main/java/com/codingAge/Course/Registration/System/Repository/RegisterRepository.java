package com.codingAge.Course.Registration.System.Repository;

import com.codingAge.Course.Registration.System.Model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RegisterRepository extends MongoRepository<Register,String> {

}
