package com.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Train;
import com.entity.User;
import com.service.TrainService;
import com.service.UserService;

@Controller
@SessionAttributes("user1")
public class TrainController {
	@Autowired
	UserService service;
	@Autowired
	TrainService service2;
	@RequestMapping(value = "/")
	public String home()
	{
		return "home";
	}
	@RequestMapping(value = "/loginForm")
	public String loginForm()
	{	
		return "loginForm";
	}
	@RequestMapping(value = "/SignUp")
	public String signUp()
	{
		return "registration";
	}
	@RequestMapping(value = "/registration")
	public String addUser(@ModelAttribute User user)
	{
		User user1=new User(user.getName(),user.getEmail(),user.getPassword(),user.getContact(),user.getGender(),user.getDob());
		service.addNewUser(user1);
		return "redirect:/loginForm";
	}
	@RequestMapping(value = "/login")
	//@ModelAttribute("user")
	public ModelAndView login(@ModelAttribute User user2,HttpSession session,Model model)
	{
		User user1=service.getUserForLogin(user2.getEmail(),user2.getPassword());
		
		if(user1!=null)
		{
			model.addAttribute("user1", user1);
			//session.setAttribute("user", user1); 
			
			if(user1.getRole().equals("Admin"))
				return new ModelAndView("adminLogin");
			else 
				return new ModelAndView("userLogin");
		}
		else
			return new ModelAndView("loginForm","wrong","invalid username/password");
	}
	@RequestMapping(value = "/SerchTrainForHome")
	public ModelAndView getSerchTrainForHome()
	{
		return new ModelAndView("trainList_home","list",service2.getAllTrain());
	}
	@RequestMapping(value = "/TrainListByNameHome")
	public ModelAndView trainListByNameHome(@ModelAttribute Train train)
	{
		System.out.println(train);
		if(train.getName().equals(""))
			return new ModelAndView("redirect:/SerchTrainForHome");
		else
			return new ModelAndView("trainList_home","list",service2.getAllTrainByName(train.getName()));
	}
	
}
