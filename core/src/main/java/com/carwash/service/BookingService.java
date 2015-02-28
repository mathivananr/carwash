package com.carwash.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.carwash.model.Booking;

@WebService
public interface BookingService {

	@GET
	@Path("/booking/getBookingById/{id}")
	@Produces("application/json")
	Booking getBookingById(@PathParam("id") String id);
	
	@GET
	@Path("/booking/getBookingByBookingId/{bookingId}")
	@Produces("application/json")
	Booking getBookingByBookingId(@PathParam("bookingId") String bookingId);
	
	@GET
	@Path("/booking/{bookingId}")
	@Produces("application/json")
	Booking getBooking(@PathParam("bookingId") String bookingId);

	@GET
	@Path("/bookings")
	@Produces("application/json")
	List<Booking> getBookings();

	@POST
	@Path("/booking")
	@Produces("application/json")
	Booking saveBooking(Booking booking) throws UserExistsException;

	@DELETE
	@Path("/booking")
	@Produces("application/json")
	void removeBooking(String bookingId);

}
