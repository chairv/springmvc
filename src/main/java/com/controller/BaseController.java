package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 */
@Controller
public class BaseController {

	@RequestMapping("base")
	public String getBase() throws Exception {
		return "redirect:/show.do";
	}

	@RequestMapping("init")
	public String init(Model model) {
		model.addAttribute("name", "lili");
		return "init";
	}
}
