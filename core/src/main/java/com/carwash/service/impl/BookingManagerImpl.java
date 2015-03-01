package com.carwash.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.Constants;
import com.carwash.dao.BookingDao;
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
		booking.setUpdatedBy(CommonUtil.getLoggedInUserName());
		int bookingCount = (int)CommonUtil.getServletcontext().getAttribute(
				Constants.BOOKING_COUNT);
		booking.setBookingId(Constants.BOOKING_ID_PREFIX
				+ Constants.BOOKING_DEFAULT_COUNT + (++bookingCount));
		booking.setBookingStatus(Constants.BOOKING_OPENED);
		booking = bookingDao.save(booking);
		CommonUtil.getServletcontext().setAttribute(Constants.BOOKING_COUNT,
				++bookingCount);
		return booking;
	}

	/**
	 * {@inheritDoc}
	 */
	public Booking updateBooking(Booking booking) throws UserExistsException{
		Calendar now = new GregorianCalendar();
		booking.setUpdatedOn(now);
		booking.setUpdatedBy(CommonUtil.getLoggedInUserName());
		booking = bookingDao.save(booking);
		return booking;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Booking cancelBooking(String bookingId) throws UserExistsException{
		Booking booking = bookingDao.getBooking(bookingId);
		Calendar now = new GregorianCalendar();
		booking.setUpdatedOn(now);
		booking.setUpdatedBy(CommonUtil.getLoggedInUserName());
		booking.setBookingStatus(Constants.BOOKING_CANCELED);
		return bookingDao.save(booking);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Booking closeBooking(String bookingId) throws UserExistsException{
		Booking booking = bookingDao.getBooking(bookingId);
		Calendar now = new GregorianCalendar();
		booking.setUpdatedOn(now);
		booking.setUpdatedBy(CommonUtil.getLoggedInUserName());
		booking.setBookingStatus(Constants.BOOKING_CLOSED);
		return bookingDao.save(booking);
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
	public Booking getBookingById(String id) {
		return bookingDao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public Booking getBookingByBookingId(String bookingId) {
		return bookingDao.getBooking(bookingId);
	}

}
