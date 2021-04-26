package com.Murut.Challenge.AlkemyChallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityController {

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/error")
    public ModelAndView error(@RequestParam Exception err) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", err);
        return modelAndView;
    }

}
