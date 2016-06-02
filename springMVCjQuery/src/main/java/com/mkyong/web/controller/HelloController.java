package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("test");
		model.addObject("msg", name);

		return model;

	}

	@RequestMapping(value = "/seeResult", //
	method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView postReader(
			@RequestParam(value = "firstName", required = false) String firstName, //
			@RequestParam(value = "lastName", required = false) String lastName//
	) {
		String name = "ok";
		ModelAndView model = new ModelAndView();
		model.setViewName("test");
		model.addObject("msg", name);
		model.addObject("firstName", firstName);
		model.addObject("lastName", lastName);
		return model;

	}

}