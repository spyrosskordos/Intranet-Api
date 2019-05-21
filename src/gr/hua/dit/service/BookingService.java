package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Booking;

public interface BookingService {
public List<Booking> getBookings();

public void confirmBooking(Booking bk);

public void saveBookings(Booking bk);

public void deleteBooking(Booking booking);

public List<Booking> getBookingByUsername(String Username);

}
