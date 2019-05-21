package gr.hua.dit.api;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Vehicle_card;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.VehicleList;
import gr.hua.dit.service.UserService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private VehicleList VehicleList;

	@RequestMapping(value = "next/{license_plate}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public List<Vehicle_card> nextDate(@PathVariable("license_plate") String lp)  {
		List<Vehicle_card> date=userService.nextDate(lp);
	
		System.out.println(date);
		return date;
	}
	@RequestMapping(value = "/{license_plate}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Vehicle searchVehicle(@PathVariable("license_plate") String lp)  {
		
		Vehicle vhcl = (Vehicle) userService.checkDB(lp);
		System.out.println(vhcl.getLicense_plate());
		return vhcl;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public VehicleList getVehicles() {

		List<Vehicle> vhcl = userService.getVehicles();
		System.out.println("customers :" + vhcl);
		this.VehicleList.setVehicleList(vhcl);
		return this.VehicleList;
	}

	

}