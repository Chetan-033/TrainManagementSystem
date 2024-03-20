package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	@Query("select max(b_id) from Booking")
	public int getNewId();
	
	@Query("select booking from Booking booking where name=?1 and u_id=?2")
	public List<Booking> getBookingForUser(String name,int u_id);
	
	@Query("select booking from Booking booking where b_id=?1")
	public Booking getBookingByBid(int b_id);
}
