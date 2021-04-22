package com.alkemyjavachallange.java_challange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    /*
     * @GetMapping("/error403") public ModelAndView error403() { ModelAndView
     * modelAndView = new ModelAndView("error403"); return modelAndView; }
     * 
     * @GetMapping("/error") public ModelAndView error() { ModelAndView modelAndView
     * = new ModelAndView("error"); return modelAndView; }
     */

}
