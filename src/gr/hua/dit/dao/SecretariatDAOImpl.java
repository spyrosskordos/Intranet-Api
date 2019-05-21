package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Booking;
import gr.hua.dit.entity.Customer;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.VehicleList;

@Repository
public class SecretariatDAOImpl implements SecretariatDAO {

	@Autowired
	private SessionFactory SessionFactory;

	@Override
	public Vehicle checkDB(String license_plate) {
		Session currentSession = SessionFactory.getCurrentSession();

		Vehicle vehicle = (Vehicle) currentSession.get(Vehicle.class, license_plate);
		return vehicle;

	}
	@Override
	
	public List<Vehicle> getVehicles() {
		Session currentSession ;
		try {
		    currentSession = SessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			currentSession = SessionFactory.openSession();
		}
		
		Query<Vehicle> query= currentSession.createQuery("from VehicleDB",Vehicle.class);
		
		// execute the query and get the results list
		List<Vehicle> vehicles = query.getResultList();

		// return the results
		return vehicles;
	}
	

}
