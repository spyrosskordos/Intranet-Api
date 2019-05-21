package gr.hua.dit.dao;

import java.util.List;


import org.hibernate.SessionFactory;


import gr.hua.dit.entity.Booking;;

public interface BookingDAO {
	public List<Booking> getBookings();
	public void confirmBooking(Booking bk);
	public void setSessionFactory(SessionFactory sf);
	public void saveBookings(Booking bk);
	public List<Booking> getBookingByUsername(String Username);
	public void deleteBooking(Booking booking);    
}
