package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.User;

public interface LoginDAO {

	public List<User> getUsers();

	public User loginUser(String username);

}
