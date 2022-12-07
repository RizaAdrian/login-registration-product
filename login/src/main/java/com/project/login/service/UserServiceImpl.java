package com.project.login.service;

import com.project.login.mapper.UserMapper;
import com.project.login.dto.UserDTO;
import com.project.login.model.ConfirmationToken;
import com.project.login.model.User;
import com.project.login.repo.UserRepository;
import com.project.login.validator.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author RizaAdrian
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

	private final static String USER_NOT_FOUND = "User with email %s not found.";
	private final UserRepository userRepository;
	private final EmailValidator emailValidator;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserMapper userMapper;
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public String register(UserDTO userDTO) {

		boolean isEmailValid = emailValidator.test(userDTO.getEmail());
		if(!isEmailValid){
			throw new IllegalStateException("Email not valid!");
		}
		return signUpUser(userMapper.sourceToDestination(userDTO));
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));

		//return userMapper.destinationToSource(user);
	}

	public String signUpUser(User user){

		boolean userExists = userRepository
				.findByEmail(user.getEmail())
				.isPresent();

		if(userExists){
			throw new IllegalStateException("Email is already taken");
		}

		String encodedPassword = bCryptPasswordEncoder
				.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepository.save(user);
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				user
		);
		confirmationTokenService.saveConfirmationToken(confirmationToken);

		return token;
	}

	@Override
	@Transactional
	public String confirmToken(String token){
		ConfirmationToken confirmationToken =
				confirmationTokenService.getToken(token)
						.orElseThrow(() -> new IllegalStateException("Token not found."));

		if (confirmationToken.getConfirmedAt() != null){
			throw new IllegalStateException("email already confirmed.");
		}
		LocalDateTime expiresAt = confirmationToken.getExpiresAt();

		if(expiresAt.isBefore(LocalDateTime.now())){
			throw new IllegalStateException("token expired");
		}

		confirmationTokenService.setConfirmedAt(token);

		enableUser(confirmationToken.getUser().getEmail());

		return "Confirmed";
	}

	public void enableUser(String email) {

		userRepository.enableUser(email);
	}
}
