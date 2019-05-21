package gr.hua.dit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import gr.hua.dit.entity.Booking;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.service.BookingService;;

@Controller
@RequestMapping("/booking")
public class BookingController {

	// inject the customer service
	@Autowired
	private BookingService bookingService;

	@GetMapping("/list")
	public String listBookings(Model model) {

		// get customers from the service
		List<Booking> bookings = bookingService.getBookings();
		// add the customers to the model
		model.addAttribute("bookings", bookings);

		// add page title
		model.addAttribute("pageTitle", "Bookings");
		System.out.println(bookings);
		return "list-bookings";
	}
	@Secured("ROLE_SEC")
	@PostMapping("/confirm")
	public String ConfirmBooking(HttpServletRequest request, @ModelAttribute("booking") Booking bk,Model model)
	throws ServletException, IOException {
		System.out.println(bk.getVehicleToCheck());
		bookingService.confirmBooking(bk);
	
		 return "redirect:/booking/list";
	}

	@Secured("ROLE_SEC")	
	@PostMapping("/deleteBooking")
	public String deleteBooking(HttpServletRequest request, @ModelAttribute("booking") Booking booking,Model model)
			throws ServletException, IOException {
		// create model attribute to get form data

		bookingService.deleteBooking(booking);

		return "redirect:/booking/list";
	}


	@GetMapping("/username")
	public String getBookingsByUserName(HttpServletRequest request, @ModelAttribute("booking") Vehicle vehicle,
			HttpServletResponse response,Model model) throws ServletException, IOException {
		
		List<Booking> bookings = bookingService.getBookingByUsername(request.getParameter("username"));

		model.addAttribute("bookings", bookings);

		// add page title
		model.addAttribute("pageTitle", "Bookings");	
		return "list-bookings";
	}
	
}