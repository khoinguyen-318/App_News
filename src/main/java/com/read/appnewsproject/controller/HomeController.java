package com.read.appnewsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends ParentController{
    @GetMapping({"/","","/index","/home"})
    public ModelAndView home(){
        return new ModelAndView("index");
    }
}
