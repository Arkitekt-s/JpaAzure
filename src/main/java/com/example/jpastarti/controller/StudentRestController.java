package com.example.jpastarti.controller;

import com.example.jpastarti.model.Student;
import com.example.jpastarti.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> lst = studentRepository.findAll();
        return lst;
    }

    @GetMapping("/addstudent")
    public List<Student> addstudent() {
        Student std = new Student();
        std.setBorn(LocalDate.now());
        std.setBornTime(LocalTime.now());
        List<Student> lst = studentRepository.findAll();
        //set name randomly name it is not unique
        Faker faker = new Faker();
        std.setName(faker.name().fullName());

        studentRepository.save(std);
        System.out.println("Student save =" + std.getName());
        return lst;
    }

}


