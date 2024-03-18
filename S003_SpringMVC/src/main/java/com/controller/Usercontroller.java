package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.userservice.UserService;

@Controller
public class Usercontroller {

	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/reg")
	public ModelAndView registration()
	{
		User user = new User();
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("reg");
		return model;
	}
	
	@RequestMapping("/adduser")
	public void addUser(@ModelAttribute("user") User u)
	{
		userService.addOrUpodateUser(u);
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/display")
	public String display()
	{
		return "display";
	}
	
}
