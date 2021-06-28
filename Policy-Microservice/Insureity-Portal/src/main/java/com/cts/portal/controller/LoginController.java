package com.cts.portal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.portal.feign.AuthClient;
import com.cts.portal.model.JwtRequest;


@Controller
@RequestMapping("/policy")
public class LoginController {
	
	@Autowired
	AuthClient client;
	
	@GetMapping(value = "/login")
	public String showLoginPage(@ModelAttribute("user") JwtRequest user, Model model) {
		return "login";
	}
	
	
	@GetMapping(value = "/logout")
	public String logoutAndShowLoginPage(Model model, HttpServletRequest request) {
		request.getSession().invalidate();
		model.addAttribute("username", null);
		return "redirect:/policy/login";
	}
	
	
	
	@PostMapping(value = "/login")
	public String afterLoginAuthenticateAndRedirect(@ModelAttribute("user") JwtRequest user, Model model,
			HttpServletRequest request) {
		ResponseEntity<?> responseGenerated = null;
		try {
			
			responseGenerated = client.createAuthenticationToken(user);
			

		} catch (Exception e) {
			System.out.println(e.getMessage()+"=========================");
			e.printStackTrace();
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "login";
		}
		@SuppressWarnings("unchecked")
		Map<String, String> tokenMap = (Map<String, String>) responseGenerated.getBody();
		String token = tokenMap.get("token");
		
		request.getSession().setAttribute("Authorization", "Bearer " + token);
		request.getSession().setAttribute("userName", user.getUserName());
		model.addAttribute("userName",  user.getUserName());
		return "welcome-page";
	}

}
