package gr.hua.dit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.hua.dit.entity.User;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// find the customerSystem
		user = currentSession.get(User.class, user.getUsername());
		// delete customer
		currentSession.delete(user);
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		user = currentSession.get(User.class, user.getUsername());

		user.setUsername("user");
		user.setPassword("pass");
		user.setEnabled((short)1);
		user.setSurname("name");
		user.setName("surname");
		user.setEmail("email");
		// delete customer
		currentSession.update(user);
	}

	@Override
	public void saveRole(User user, String role) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		NativeQuery sql=currentSession.createNativeQuery("INSERT INTO authorities(username,authority) VALUES('"+ user.getUsername() +"', '"+ role + "')");
		sql.executeUpdate();

	}

	@Override
	public void deleteRole(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		NativeQuery sql=currentSession.createNativeQuery("Delete from authorities where username='"+ user.getUsername() +"'");
		sql.executeUpdate();
		
	}

}
