package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Booking;
import com.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository repository;
	
	public void setBooking(Booking booking)
	{
		repository.save(booking);
	}
	public int getNewId()
	{
		return repository.getNewId()+1;
	}
	public List<Booking> getBookingForUser(String name,int id)
	{
		return repository.getBookingForUser(name,id);
	}
	public void cancelBooking(int b_id)
	{
		repository.deleteById(b_id);
	}
	public Booking getBookingByBid(int b_id)
	{
		return repository.getBookingByBid(b_id);
	}
	public List<Booking> getAllBooking()
	{
		return repository.findAll();
	}
}
