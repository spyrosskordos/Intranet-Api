package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.BookingDAO;

import gr.hua.dit.entity.Booking;


@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDAO bookingDAO;
	@Override
	@Transactional
	public List<Booking> getBookings() {
		return 	bookingDAO.getBookings();
	}
	
	@Override
	@Transactional
	public void confirmBooking(Booking bk) {
		bookingDAO.confirmBooking(bk);
	
	}

	@Override
	@Transactional
	public List<Booking> getBookingByUsername(String Username) {
		return bookingDAO.getBookingByUsername(Username);
		
	}

	@Override
	@Transactional
	public void saveBookings(Booking bk) {
		bookingDAO.saveBookings(bk);
		
	}

	@Override
	@Transactional
	public void deleteBooking(Booking booking) {
		bookingDAO.deleteBooking(booking);
	}
	
	
	
	
	
}