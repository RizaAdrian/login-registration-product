package com.project.login.service;

import com.project.login.dto.UserDTO;

/**
 * @author RizaAdrian
 */
public interface UserService {

	String register(UserDTO userDTO);

	void enableUser(String email);

	String confirmToken(String token);
}
