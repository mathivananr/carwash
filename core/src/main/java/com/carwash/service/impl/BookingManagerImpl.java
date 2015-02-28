package com.carwash.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.carwash.Constants;
import com.carwash.dao.BookingDao;
import com.carwash.dao.UserDao;
import com.carwash.model.Booking;
import com.carwash.service.BookingManager;
import com.carwash.service.BookingService;
import com.carwash.service.UserExistsException;
import com.carwash.util.CommonUtil;

@Service("bookingManager")
@WebService(serviceName = "BookingService", endpointInterface = "com.carwash.service.BookingService")
public class BookingManagerImpl extends GenericManagerImpl<Booking, String>
		implements BookingManager, BookingService {

	BookingDao bookingDao;

	@Autowired
	public BookingManagerImpl(BookingDao bookingDao) {
		super(bookingDao);
		this.bookingDao = bookingDao;
	}
	
	@Autowired
    public void setBookingDao(BookingDao bookingDao) {
        this.dao = bookingDao;
        this.bookingDao = bookingDao;
    }
	
	/**
	 * {@inheritDoc}
	 */
	public Booking getBooking(String bookingId) {
		return bookingDao.getBooking(bookingId);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Booking> getBookings() {
		return bookingDao.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public Booking saveBooking(Booking booking) throws UserExistsException {
		Calendar now = new GregorianCalendar();
		booking.setCreatedOn(now);
		booking.setUpdatedOn(now);
		booking.setCreatedBy(CommonUtil.getLoggedInUserName());
		booking.setCreatedBy(CommonUtil.getLoggedInUserName());
		int bookingCount = (int)CommonUtil.getServletcontext().getAttribute(
				Constants.BOOKING_COUNT);
		booking.setBookingId(Constants.BOOKING_ID_PREFIX
				+ Constants.BOOKING_DEFAULT_COUNT + (++bookingCount));
		booking = bookingDao.save(booking);
		CommonUtil.getServletcontext().setAttribute(Constants.BOOKING_COUNT,
				++bookingCount);
		return booking;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBooking(String bookingId) {
		bookingDao.removeBooking(bookingId);
	}

	/**
	 * {@inheritDoc}
	 */
	public Booking getBookingById(@PathParam("id") String id) {
		return bookingDao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public Booking getBookingByBookingId(
			@PathParam("bookingId") String bookingId) {
		return bookingDao.getBooking(bookingId);
	}

}
