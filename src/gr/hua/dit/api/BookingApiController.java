package gr.hua.dit.api;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Booking;
import gr.hua.dit.entity.BookingList;
import gr.hua.dit.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingApiController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BookingList bookingList;


		@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
		public BookingList getBookingsByUsername(@PathVariable("username") String Username) {
	
			List<Booking> bookings= bookingService.getBookingByUsername(Username);
			System.out.println(bookings);
	
			
			this.bookingList.setBookingList(bookings);
			return this.bookingList;
		}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public 	BookingList getBookings() {

		List<Booking> Bookings = bookingService.getBookings();
		System.out.println("Bookings :" + Bookings);
		this.bookingList.setBookingList(Bookings);
		return this.bookingList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Booking createBooking(@RequestParam("date") Date date,
			@RequestParam("time") Time time, @RequestParam("username") String username,@RequestParam("vehicleToCheck") String vhcl) {
		Booking booking = new Booking(date,time,username,vhcl,false);
	
		bookingService.saveBookings(booking);
		return booking;

	}

	


}