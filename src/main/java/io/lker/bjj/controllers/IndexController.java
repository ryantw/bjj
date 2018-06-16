package io.lker.bjj.controllers;

import io.lker.bjj.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final StudentService studentService;

    public IndexController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        //log.debug("Retrieving index page")
        model.addAttribute("students", studentService.getStudents());

        return "index";
    }
}
