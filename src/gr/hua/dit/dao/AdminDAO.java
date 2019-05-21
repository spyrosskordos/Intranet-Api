package gr.hua.dit.dao;

import gr.hua.dit.entity.User;

public interface AdminDAO {

	public void saveUser(User user);

	public void deleteUser(User user);

	public void deleteRole(User user);
	
	public void updateUser(User user);
	
	public void saveRole(User user,String role);
}
