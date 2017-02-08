package com.ym.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/Test.do")
	public ModelAndView Test(HttpServletRequest req){
    	ModelAndView m = new ModelAndView();
    	m.setViewName("../views/index");
    	return m;
	}
}
