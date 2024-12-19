package com.example.MongoDB.controller;

import com.example.MongoDB.model.Student;
import com.example.MongoDB.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")    //path for localhost we take any name here


public class MyController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping ("/")

    public ResponseEntity<?> addStudent(@RequestBody Student student){   //RequestBody Means --convert Java code into JSON format to postman


        Student save= this.studentRepository.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping ("/")

    public ResponseEntity<?> getStudent(){


        return ResponseEntity.ok(this.studentRepository.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {           //pathvariable- denoted for localhost id denotation
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Student with ID " + id + " not found.");
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id); // Ensure the ID is retained
            Student savedStudent = studentRepository.save(updatedStudent);
            return ResponseEntity.ok(savedStudent);
        } else {
            return ResponseEntity.status(404).body("Student with ID " + id + " not found.");
        }
    }





}
