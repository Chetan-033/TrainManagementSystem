package com.Controller;

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
import com.service.BookingService;
import com.service.TrainService;
import com.service.UserService;

@Controller
@SessionAttributes("user1")
public class AdminController {
	
	@Autowired
	UserService service;
	@Autowired
	BookingService service1;
	@Autowired
	TrainService service2;
	
	@RequestMapping(value = "/adminHome")
	public String adminHome(Model model)
	{
		if(model.getAttribute("user1").equals(""))
			return "redirect:/loginForm";
		else
			return "adminLogin";	
	}
	
	@RequestMapping(value = "/AddTrain")
	public String addTrainForm(Model model)
	{
		if(model.getAttribute("user1").equals(""))
			return "redirect:/loginForm";
		else
			return "addTrain";
	}
	@RequestMapping(value = "/addTrain")
	public String addTrain(@ModelAttribute Train train)
	{
		train.setId(service2.getNewId());
		service2.addNewTrain(train);
		return "redirect:/TrainList";
	}
	@RequestMapping(value = "/TrainList")
	public ModelAndView trainList(Model model)
	{
		if(model.getAttribute("user1").equals(""))
			return new ModelAndView("redirect:/loginForm");
		else
		return new ModelAndView("trainList","list",service2.getAllTrain());
	}
	@RequestMapping(value = "/TrainListByName")
	public ModelAndView trainListByName(@ModelAttribute Train train)
	{
		System.out.println(train);
		if(train.getName().equals(""))
			return new ModelAndView("redirect:/TrainList");
		else
			return new ModelAndView("trainList","list",service2.getAllTrainByName(train.getName()));
	}
	@RequestMapping(value = "/setLogout")
	public String logout(Model model)
	{
		model.addAttribute("user1","");
		return "redirect:/";
	}
	@RequestMapping(value = "/deleteTrain/{id}")
	public String deleteTrainById(@PathVariable("id") int id)
	{
		service2.deleteTrain(id);
		return "redirect:/TrainList";
	}
	@RequestMapping(value = "/MyProfile")
	public ModelAndView getMyProfile()
	{
		return new ModelAndView("myProfile"); 
	}
	@RequestMapping(value = "/BookingList")
	public ModelAndView getBookings(Model model)
	{
		User user=(User) model.getAttribute("user1");
		if(user.equals(""))
			return new ModelAndView("redirect:/loginForm");
		else	
			return new ModelAndView("bookingList","list",service1.getAllBooking());
	}
	
}
