package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Booking;
import com.entity.Train;
import com.entity.User;
import com.service.BookingService;
import com.service.TrainService;
import com.service.UserService;

@Controller
@SessionAttributes("user1")
public class UserController {
	
	@Autowired
	UserService service;
	@Autowired
	BookingService service1;
	@Autowired
	TrainService service2;
	
	@RequestMapping(value = "/userHome")
	public String adminHome(Model model)
	{
		if(model.getAttribute("user1").equals(""))
			return "redirect:/loginForm";
		else
			return "userLogin";
	}
	@RequestMapping(value = "/TrainListUser")
	public ModelAndView trainList(Model model)
	{
		if(model.getAttribute("user1").equals(""))
			return new ModelAndView("redirect:/loginForm");
		else
		return new ModelAndView("trainList_user","list",service2.getAllTrain());
	}
	@RequestMapping(value = "/TrainListByDestination")
	public ModelAndView trainListByDestination(@ModelAttribute Train train)
	{
		System.out.println(train);
		if(train.getT_from().equals("")&&train.getT_to().equals(""))
			return new ModelAndView("redirect:/TrainListUser");
		else
			return new ModelAndView("trainList_user","list",service2.getTrainByDestination(train.getT_from(), train.getT_to()));
	}
	@RequestMapping(value = "/userProfile")
	public ModelAndView getMyProfile()
	{
		return new ModelAndView("UserProfile"); 
	}
	@RequestMapping(value = "/bookingSeat/{id}")
	public ModelAndView bookingSeat(@PathVariable("id") int id)
	{
		return new ModelAndView("BookingForm","train",service2.getTrainById(id));
	}
	@RequestMapping(value = "/BookedSeat")
	public ModelAndView BookedSeat(@ModelAttribute Booking booking,Model model)
	{
		User user=(User)model.getAttribute("user1");
		Train train=service2.getTrainByNameNo(booking.getTrainno(),booking.getT_name());
		Booking booking1=new Booking(service1.getNewId(),booking.getName(),booking.getTrainno(),booking.getT_name(),booking.getAdult(),booking.getChild(),user.getId(),train.getDate());
		booking1.setTotalmember(booking.getAdult()+booking.getChild());
		booking1.setTotalamount(train.getRate()*booking1.getTotalmember());
		if(booking1.getTotalamount()>0&&train.getSeat()>=booking1.getTotalmember())
		{
			model.addAttribute("booking", booking1);
			return new ModelAndView("Payment");
		}	
		else
			return new ModelAndView("redirect:/TrainListUser");
	}
	@RequestMapping(value = "/finalPayment")
	public ModelAndView finalPayment(@ModelAttribute Booking booking,Model model)
	{
		User user=(User)model.getAttribute("user1");
		Train train=service2.getTrainByNameNo(booking.getTrainno(),booking.getT_name());
		Booking booking1=new Booking(service1.getNewId(),booking.getName(),booking.getTrainno(),booking.getT_name(),booking.getAdult(),booking.getChild(),user.getId(),train.getDate());
		booking1.setTotalmember(booking.getAdult()+booking.getChild());
		booking1.setTotalamount(train.getRate()*booking1.getTotalmember());
		System.out.println(booking1);
		service1.setBooking(booking1);
		train.setSeat(train.getSeat()-booking1.getTotalmember());
		service2.bookSeat(train);
		return new ModelAndView("redirect:/user_Booking");
	}
	@RequestMapping(value = "/user_Booking")
	public ModelAndView getBookings(Model model)
	{
		User user=(User) model.getAttribute("user1");
		return new ModelAndView("user_booking","list",service1.getBookingForUser(user.getName(), user.getId()));
	}
	@RequestMapping(value = "/CancelSeat/{id}")
	public ModelAndView cancelBooking(@PathVariable("id") int id)
	{
		Booking booking=service1.getBookingByBid(id);
		System.out.println(booking);
		Train train=service2.getTrainByNameNo(booking.getTrainno(),booking.getT_name());
		train.setSeat(train.getSeat()+booking.getTotalmember());
		service1.cancelBooking(id);
		return new ModelAndView("redirect:/user_Booking");
	}
	@RequestMapping(value = "/ticketInvoice/{id}")
	public ModelAndView getInvoice(@PathVariable("id") int id,Model model)
	{
		Booking booking=service1.getBookingByBid(id);
		Train train=service2.getTrainByNameNo(booking.getTrainno(),booking.getT_name());
		model.addAttribute("booking",booking);
		return new ModelAndView("TicketInvoice","train",train);
	}
	@RequestMapping(value = "/userBooking")
	public String backToBooking(Model model)
	{
		if(model.getAttribute("user1").equals(""))
			return "redirect:/loginForm";
		else
			return "redirect:/user_Booking";
	}
}
