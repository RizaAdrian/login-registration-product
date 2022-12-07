package com.project.login.dto;


import com.project.login.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author RizaAdrian
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class UserDTO {
	private String name;
	private String username;
	private String email;
	private String password;
	private UserRole userRole;
}
