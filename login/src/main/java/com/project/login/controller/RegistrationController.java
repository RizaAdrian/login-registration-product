package com.project.login.controller;

import com.project.login.dto.UserDTO;
import com.project.login.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RizaAdrian
 */
@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
public class RegistrationController {

	private UserService userService;

	@PostMapping
	public String register(@RequestBody UserDTO userDTO){
		System.out.println("CONTROLLER");
		return userService.register(userDTO);
	}

	@GetMapping(path = "confirm")
	public String confirm(@RequestParam("token") String token) {
		return userService.confirmToken(token);
	}

}
