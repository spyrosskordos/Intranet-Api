package gr.hua.dit.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.annotation.Secured;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import gr.hua.dit.entity.User;
import gr.hua.dit.entity.Vehicle;
import gr.hua.dit.entity.Vehicle_card;
import gr.hua.dit.service.LoginService;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	public static String vhcl = null;
	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;
	
	@GetMapping("/adminForm")
	public String adminForm(Model model) {
		// get customers from the service
		List<User> users = loginService.getCustomers();
		// add the customers to the model
		model.addAttribute("users", users);

		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Admin");
		return "admin-form";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/registerUser")
	public String createUser(HttpServletRequest request, @ModelAttribute("user") User user,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			userService.saveUser(user);
			userService.saveRole(user, request.getParameter("role"));
		} catch (DataIntegrityViolationException e) {
			request.setAttribute("create", "Create Failed");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin-form.jsp");
			rd.forward(request, response);
		} catch (java.lang.IllegalStateException e) {
			request.setAttribute("update_msg", "Username does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/user/adminForm");
			rd.forward(request, response);
		}
		return "redirect:/user/adminForm";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request, @ModelAttribute("user") User user,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			userService.deleteRole(user);
			userService.deleteUser(user);
		} catch (java.lang.IllegalArgumentException e) {
			request.setAttribute("delete_msg", "Username does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/admin-form.jsp");
			rd.forward(request, response);
		}
		return "redirect:/user/adminForm";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/UpdateUser")
	public String userUpdate(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Update");
		return "update-user";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, @ModelAttribute("user") User user,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			userService.deleteRole(user);
			userService.deleteUser(user);
		} catch (java.lang.IllegalArgumentException e) {
			request.setAttribute("update_msg", "Username does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/user/adminForm");
			rd.forward(request, response);
		}
		return "redirect:/user/UpdateUser";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/updateUseradd")
	public String updateUseradd(HttpServletRequest request, @ModelAttribute("user") User user,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			userService.saveUser(user);
		} catch (DataIntegrityViolationException e) {
			request.setAttribute("update_msg", "Username does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update-user.jsp");
			rd.forward(request, response);
		}
		return "redirect:/user/adminForm";
	}
	
	@GetMapping("/secretariatForm")
	public String secretariatForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Secretariat");
		return "secretariat-form";
	}
	@Secured("ROLE_SEC")
	@RequestMapping("/searchDB")
	public String searchVehicle(HttpServletRequest request, @ModelAttribute("vehicleDB") Vehicle vehicle,
			HttpServletResponse response) throws ServletException, IOException {

		Vehicle vhcl = userService.checkDB(request.getParameter("id"));
		if (vhcl == null) {
			
			request.setAttribute("message", "This vehicle does not exist into DB");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/secretariat-form.jsp");
			rd.forward(request, response);
			
			return "redirect:/user/secretariatForm";

		} else {
			if (vhcl.getInsurance().equals("yes")) {
				if (vhcl.getType().equals("car")) {
					if (vhcl.getSub_type() > 1800) {

						request.setAttribute("payment", "80");
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/secretariat-form.jsp");
						rd.forward(request, response);
						return "redirect:/user/secretariatForm";
					} else {

						request.setAttribute("payment", "50");
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/secretariat-form.jsp");
						rd.forward(request, response);
						return "redirect:/user/secretariatForm";
					}
				} else {
					if (vhcl.getSub_type() > 3) {

						request.setAttribute("payment", "150");
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/secretariat-form.jsp");
						rd.forward(request, response);
						return "redirect:/user/secretariatForm";
					} else {

						request.setAttribute("payment", "100");
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/secretariat-form.jsp");
						rd.forward(request, response);
						return "redirect:/user/secretariatForm";
					}
				}

			} else {

				request.setAttribute("payment", "200");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/secretariat-form.jsp");
				rd.forward(request, response);
				return "redirect:/user/secretariatForm";
			}

		}

	}

	@GetMapping("/technicianForm")
	public String technicianForm(Model model) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Technician");
		return "technician-form";
	}
	@Secured("ROLE_TECH")
	@RequestMapping("/createCard")
	public String createCard(HttpServletRequest request, @ModelAttribute("vehicle_card") Vehicle_card vehicle,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if (vehicle == null) {
				request.setAttribute("create", "You have to fill all the fields");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/technician-form.jsp");
				rd.forward(request, response);
			}
			userService.createCard(vehicle);
		} catch (DataIntegrityViolationException e) {
			request.setAttribute("create", "Vehicle already exist!");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/technician-form.jsp");
			rd.forward(request, response);
		}
		return "redirect:/user/technicianForm";
	}
	@Secured("ROLE_TECH")
	@GetMapping("/UpdateVehicleCard")
	public String updateVehicleCard(Model model) {
		// create model attribute to get form data
		Vehicle_card vehicle_crd = new Vehicle_card();
		model.addAttribute("user", vehicle_crd);

		// add page title
		model.addAttribute("pageTitle", "Update Vehicle Card");
		return "update-card";
	}
	@Secured("ROLE_TECH")
	@RequestMapping("/updateCardDelete")
	 public String updateCardDelete(HttpServletRequest request, @ModelAttribute("vehicle_card") Vehicle_card vehicle,
		    	HttpServletResponse response) throws ServletException, IOException {
		try {
			vhcl = vehicle.getLicense_plate().toString();
			userService.deleteCard(vehicle);
		} catch (java.lang.IllegalArgumentException e) {
			request.setAttribute("update_msg", "License plate does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("/user/technicianForm");
			rd.forward(request, response);
		}

		return "redirect:/user/UpdateVehicleCard";
	}
	@Secured("ROLE_TECH")
	@RequestMapping("/updateCardadd")
	public String updateCardAdd(HttpServletRequest request, @ModelAttribute("vehicle_card") Vehicle_card vehicle,
			HttpServletResponse response) throws ServletException, IOException {
		vehicle.setLicense_plate(vhcl);
		userService.createCard(vehicle);

		return "redirect:/user/technicianForm";
	}
}
