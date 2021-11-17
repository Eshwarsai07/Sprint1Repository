package com.multiplex.bookingsystem.users.usercontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.multiplex.bookingsystem.movies.entity.Movies;
import com.multiplex.bookingsystem.movies.entity.Shows;

import com.multiplex.bookingsystem.users.entity.Users;
import com.multiplex.bookingsystem.users.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/AMB")
	public String diplay(Model m) {
		String str = "WELCOME TO AMB MOVIES";
		m.addAttribute("message", str);
		return "homepage";
	}

	@GetMapping("/AMB/userregistration")
	public String displayPort() {
		return "registrationview";
	}

	@PostMapping("/AMB/registered")
	public String registration(HttpServletRequest req, Model m1) {
		String username = req.getParameter("userName");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String pass = req.getParameter("userPassword");
		Users u = new Users();
		u.setEmail(email);
		u.setMobile(mobile);
		u.setUserName(username);
		u.setUserPassword(pass);
		service.addUser(u);

		return "success";

	}

	@GetMapping("/AMB/hello")
	public String jdakj() {
		return "sucess";
	}

	@GetMapping("/AMB/userlogin")
	public String userLogin() {
		return "userloginview";
	}

	@PostMapping("/AMB/loggedin")
	public String loggin(HttpServletRequest req, Model m) {
		String username = req.getParameter("userName");
		String pass = req.getParameter("userPassword");
		Users u = service.getUser(username);

		if (u == null)
			return "loginfailed";
		else {
			if (u.getUserPassword().equals(pass)) {
				return "loginsucess";
			} else {
				return "loginfailed";
			}
		}

	}

}
