package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tancw on 2016/3/17.
 */
@Controller
public class ShowController {

	@RequestMapping("show")
	public ModelAndView handleRequest() throws Exception {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("title", "Spring mvc and Freemarker");
		mv.addObject("content", "Hello world, test my first spring mvc");
		return mv;
	}
}
