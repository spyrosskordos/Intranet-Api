package gr.hua.dit.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gr.hua.dit.dao.LoginDAO;
import gr.hua.dit.entity.User;

@Service
public class LoginServiceImpl implements LoginService {

	// inject the CustomerDAO
	@Autowired
	private LoginDAO logDao;

	@Override
	@Transactional
	public List<User> getCustomers() {
		return logDao.getUsers();
	}

	@Override
	@Transactional
	public User loginUser(String username) {
		return logDao.loginUser(username);
	}

}