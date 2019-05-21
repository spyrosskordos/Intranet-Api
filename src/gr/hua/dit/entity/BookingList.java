package gr.hua.dit.entity;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name = "BookingList")
@Component
public class BookingList {

	List<Booking> BookingList;

	public List<Booking> getBookingList() {
		return BookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.BookingList = bookingList;
	}

}
