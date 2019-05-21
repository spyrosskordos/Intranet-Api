package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle_card;

@Repository
public class TechnicianDAOImpl implements TechnicianDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createCard(Vehicle_card vehicle) {
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		currentSession.save(vehicle);
	}

	
	@Override
	public void deleteCard(Vehicle_card vehicle) {
		Session currentSession = sessionFactory.getCurrentSession();
		// save the customer
		vehicle = currentSession.get(Vehicle_card.class, vehicle.getLicense_plate());
		currentSession.delete(vehicle);
	}


	@Override
	public List<Vehicle_card> nextDate(String license_plate) {
		Session currentSession = sessionFactory.getCurrentSession();

		String SQL = "select next_inspection_date from Vehicle_card where license_plate ='"+ license_plate+"'";
		  Query query = currentSession.createQuery(SQL);
		  List<Vehicle_card> result=query.getResultList();
				return result;
	}
}
