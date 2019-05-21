package gr.hua.dit.dao;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.Booking;





@Repository
public class BookingDAOImpl implements BookingDAO {
	
	@Autowired
	private SessionFactory SessionFactory;
	
	   @Override
	   public void setSessionFactory(SessionFactory sf){
	        this.SessionFactory = sf;
	    }
	public List<Booking> getBookings(){
		// get current hibernate session
		Session currentSession = SessionFactory.getCurrentSession();

		// create a query
		Query<Booking> query = currentSession.createQuery("from Booking order by username", Booking.class);

		// execute the query and get the results list
		List<Booking> bookings = query.getResultList();

		// return the results
		return bookings;
	}
	@Override
	public void confirmBooking(Booking bk) {
		
        Session session = this.SessionFactory.getCurrentSession();
        String SQL = "update Booking set confirmed = 1 where vehicleToCheck ='"+ bk.getVehicleToCheck()+"'";

    Query query = session.createQuery(SQL);
    query.executeUpdate();
		
	}
	@Override
	public void deleteBooking(Booking booking) {
		// get current hibernate session
		Session currentSession = SessionFactory.getCurrentSession();

		String SQL = "delete from Booking where vehicleToCheck ='"+ booking.getVehicleToCheck()+"'";
		  Query query = currentSession.createQuery(SQL);
		    query.executeUpdate();
				
		
	}
	@Override
	public List<Booking> getBookingByUsername(String Username) {
		Session currentSession ;
		try {
		    currentSession = SessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			currentSession = SessionFactory.openSession();
		}
		// create a query
	
		List<Booking> bookings = currentSession.createQuery("from Booking where username='"+Username+"'",Booking.class).list();

		// execute the query and get the results list
	
		 return bookings;
	
	}
	@Override
	public void saveBookings(Booking bk) {
		// get current hibernate session
		System.out.println(bk.getUsername());

        Session session = this.SessionFactory.getCurrentSession();
       session.save(bk);
		
	}
	
}