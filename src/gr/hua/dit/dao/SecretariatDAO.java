package gr.hua.dit.dao;

import java.util.List;


import gr.hua.dit.entity.Vehicle;
public interface SecretariatDAO {

	public Vehicle checkDB(String license_plate);

	public List<Vehicle> getVehicles();
}
