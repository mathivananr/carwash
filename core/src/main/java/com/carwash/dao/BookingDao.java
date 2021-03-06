package com.carwash.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.carwash.model.Booking;

public interface BookingDao extends GenericDao<Booking, String> {
	
	@Transactional
	List<Booking> getAll();
	
	@Transactional
	Booking save(Booking booking);
	
	@Transactional
	Booking get(String id);

	@Transactional
	Booking getBooking(String bookingId);
	
	@Transactional
	void removeBooking(String bookingId);
}
