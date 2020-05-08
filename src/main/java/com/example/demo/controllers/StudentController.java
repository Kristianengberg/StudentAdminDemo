package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.InMemoryStudentRepositoryImpl;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    private IStudentRepository studentRepository;

    public StudentController() {
        studentRepository = new InMemoryStudentRepositoryImpl();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students" , studentRepository.readAll());
        return "index";
    }

    @GetMapping("/student")
    @ResponseBody
    public String getStudentByParameter(@RequestParam int id) {
        Student stu = studentRepository.read(id);
        return "The name is: " + stu.getFirstName() + " and the cpr is " + stu.getCpr();
    }
    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @GetMapping("/edit")
    public String edit(Model model){
        model.addAttribute("students" , studentRepository.readAll());
        return "edit";
    }



    @GetMapping("/test")
    public String test(){
        return "test";
    }
/*
    @GetMapping("/edit")
    @ResponseBody
    public Student getStudentByParameter123(@RequestParam int id) {
        Student stu = studentRepository.read(id);
        return stu;
    }
*/

}