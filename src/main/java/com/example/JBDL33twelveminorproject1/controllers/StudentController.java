package com.example.JBDL33twelveminorproject1.controllers;

import com.example.JBDL33twelveminorproject1.models.Student;
import com.example.JBDL33twelveminorproject1.request.BookCreateRequest;
import com.example.JBDL33twelveminorproject1.request.StudentCreateRequest;
import com.example.JBDL33twelveminorproject1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.create(studentCreateRequest);
    }

    //we do not add the id in the URL because it is too insecure
//    @GetMapping("/student/{id}")
//    public Student getStudent(@PathVariable("id") int id){
//
//    }
}
