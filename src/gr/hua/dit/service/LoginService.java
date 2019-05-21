package gr.hua.dit.service;

import java.util.List;
import gr.hua.dit.entity.User;

public interface LoginService {

	public List<User> getCustomers();

	public User loginUser(String username);

}