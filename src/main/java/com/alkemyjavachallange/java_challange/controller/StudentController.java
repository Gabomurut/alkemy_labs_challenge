package com.alkemyjavachallange.java_challange.controller;

import com.alkemyjavachallange.java_challange.data.AssignmentRepository;
import com.alkemyjavachallange.java_challange.data.StudentsAssignmentsRepository;
import com.alkemyjavachallange.java_challange.data.TeacherRepository;
import com.alkemyjavachallange.java_challange.model.Assignment;
import com.alkemyjavachallange.java_challange.model.StudentsAssignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentsAssignmentsRepository studentsAssignmentsRepository;

    @GetMapping("/user/{name}")
    public ModelAndView user(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView(name);
        modelAndView.addObject("studentsAssignmentsList",
                studentsAssignmentsRepository.findAllByOrderByAssignmentName());
        modelAndView.addObject("assignemntList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @GetMapping("/user/assignments/{id}")
    public ModelAndView userAssignment(@PathVariable int id) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView modelAndView = new ModelAndView("singleAssignment");
        Assignment assignment = assignmentRepository.findById(id).get();

        if (studentsAssignmentsRepository.existsByStudentAssignmentIdAndStudentDni(id, userName)) {
            modelAndView.addObject("display", true);
            modelAndView.addObject("disabled", true);

        } else {
            modelAndView.addObject("display", false);
        }

        if (studentsAssignmentsRepository.existsByScheduleAndStudentDni(assignment.getSchedule(), userName)) {
            modelAndView.addObject("schedule", true);
            modelAndView.addObject("disabled", true);
        } else {
            modelAndView.addObject("schedule", false);
        }

        modelAndView.addObject("assignment", assignment);
        modelAndView.addObject("teacher", teacherRepository.findByLastName(assignment.getTeacher()));
        return modelAndView;
    }

    @PostMapping("/user/assignments/{id}")
    public ModelAndView addStudentAssignment(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("singleAssignment");
        Assignment assignment = assignmentRepository.findById(id).get();
        StudentsAssignments studentsAssignments = new StudentsAssignments(assignment.getId(),
                SecurityContextHolder.getContext().getAuthentication().getName(), assignment.getName(),
                assignment.getSchedule(), assignment.getTeacher());
        assignment.setMaxStudents(assignment.getMaxStudents() - 1);
        studentsAssignmentsRepository.save(studentsAssignments);
        modelAndView.addObject("assignment", assignment);
        modelAndView.addObject("disabled", true);
        modelAndView.addObject("display", true);
        modelAndView.addObject("assignmentList", assignmentRepository.findAllByOrderByName());
        modelAndView.addObject("teacherList", teacherRepository.findAllByOrderByName());
        return modelAndView;
    }

    @DeleteMapping("/user/studentAssignments/{id}")
    public ModelAndView deleteTeacher(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("studentAssignments");
        studentsAssignmentsRepository.deleteById(id);
        Assignment assignment = assignmentRepository.findById(id).get();
        assignment.setMaxStudents(assignment.getMaxStudents() + 1);
        assignmentRepository.save(assignment);
        modelAndView.addObject("studentsAssignmentsList",
                studentsAssignmentsRepository.findAllByOrderByAssignmentName());
        return modelAndView;
    }

}