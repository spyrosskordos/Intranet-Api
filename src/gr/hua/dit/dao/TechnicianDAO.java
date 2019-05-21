package gr.hua.dit.dao;


import java.util.List;

import gr.hua.dit.entity.Vehicle_card;

public interface TechnicianDAO {
	public void createCard(Vehicle_card vehicle);
	
	public List<Vehicle_card> nextDate(String license_plate);
	
	public void deleteCard(Vehicle_card vehicle);
}
