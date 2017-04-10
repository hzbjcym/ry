package com.ym.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ym.base.BaseController;

@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
	
	@RequestMapping("/Test.do")
	public ModelAndView Test(HttpServletRequest req){
		logger.info("1111111111");
		logger.debug("1111");
		logger.error("1111");
    	ModelAndView m = new ModelAndView();
    	m.setViewName("../views/index");
    	return m;
	}
}
