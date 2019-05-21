package gr.hua.dit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.entity.User;


@Controller
@RequestMapping("/login")
public class LoginController {



	@GetMapping("/showLoginForm")
	public String showLoginForm(HttpServletRequest request, Model model, HttpServletResponse response) {
		// create model attribute to get form data
		User user = new User();
		model.addAttribute("user", user);

		// add page title
		model.addAttribute("pageTitle", "Login");
		return "login-form";
	}

	 @GetMapping("/success")
	    public String loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

	        String role =  authResult.getAuthorities().toString();

	        if(role.contains("ROLE_ADMIN")){
	         return "admin-form";                            
	         }
	         else if(role.contains("ROLE_SECR")) {
	             return "secretariat-form";
	         }
	        return"list-customers";
	    }
		

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login/showLoginForm";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

}
