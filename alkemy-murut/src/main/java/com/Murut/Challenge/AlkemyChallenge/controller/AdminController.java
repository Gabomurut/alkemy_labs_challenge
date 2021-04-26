package com.Murut.Challenge.AlkemyChallenge.controller;

import com.Murut.Challenge.AlkemyChallenge.data.AssignmentRepository;
import com.Murut.Challenge.AlkemyChallenge.data.TeacherRepository;
import com.Murut.Challenge.AlkemyChallenge.model.Assignment;
import com.Murut.Challenge.AlkemyChallenge.model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/admin/{name}")
    public ModelAndView admin(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView(name);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @PostMapping("/admin/assignments")
    public ModelAndView addAssignment(@ModelAttribute Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView("assignments");
        assignmentRepository.save(assignment);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @PostMapping("/admin/teachers")
    public ModelAndView addTeacher(@ModelAttribute Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView("teachers");
        teacherRepository.save(teacher);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @DeleteMapping("/admin/teachers/{id}")
    public ModelAndView deleteTeacher(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("teachers");
        teacherRepository.deleteById(id);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @DeleteMapping("/admin/assignments/{id}")
    public ModelAndView deleteAssignment(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("assignments");
        assignmentRepository.deleteById(id);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @PutMapping("/admin/teachers/{id}")
    public ModelAndView updateTeacher(@ModelAttribute Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView("teachers");
        teacherRepository.save(teacher);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @PutMapping("/admin/assignments/{id}")
    public ModelAndView updateAssignment(@ModelAttribute Assignment assignment) {
        ModelAndView modelAndView = new ModelAndView("assignments");
        assignmentRepository.save(assignment);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @PostMapping("/admin/editTeachers")
    public ModelAndView editTeacher(int id) {
        ModelAndView modelAndView = new ModelAndView("teachers");
        modelAndView.addObject("id", id);
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @PostMapping("/admin/editAssignment")
    public ModelAndView editAssignment(int id) {
        ModelAndView modelAndView = new ModelAndView("assignments");
        modelAndView.addObject("id", id);
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

}
