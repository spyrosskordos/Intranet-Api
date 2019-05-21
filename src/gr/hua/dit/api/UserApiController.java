package gr.hua.dit.api;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import gr.hua.dit.entity.User;


import gr.hua.dit.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

	@Autowired
	private UserService userService;




	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public User createCustomer(@RequestParam("username") String username,@RequestParam("password") String password,
			@RequestParam("name") String name, @RequestParam("surname") String surname,@RequestParam("email") String email) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled((short) 0);
		user.setEmail(email);
		user.setName(name);
		user.setSurname(surname);
		userService.saveUser(user);
		userService.saveRole(user, "ROLE_USER");
		return user;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public User createUserromJson(@RequestBody User user) {
		
		userService.saveUser(user);
		return user;
	}
	


}