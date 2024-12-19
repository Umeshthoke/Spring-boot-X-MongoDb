package com.example.MongoDB.repo;

import com.example.MongoDB.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {

                               //for Student class and id of datatype we put into mongoRepository
}
