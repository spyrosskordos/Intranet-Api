package gr.hua.dit.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.User;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<User> query = currentSession.createQuery("from User order by username", User.class);

		// execute the query and get the results list
		List<User> users = query.getResultList();
		// return the results
		return users;
	}

	@Override
	public User loginUser(String username) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		User user = (User) currentSession.get(User.class, username);
		return user;

	}

}
