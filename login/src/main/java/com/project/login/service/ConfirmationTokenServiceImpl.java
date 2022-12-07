package com.project.login.service;

import com.project.login.model.ConfirmationToken;
import com.project.login.repo.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author RizaAdrian
 */
@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{

	private final ConfirmationTokenRepository confirmationTokenRepository;

	@Override
	public void saveConfirmationToken(ConfirmationToken token){
		confirmationTokenRepository.save(token);
	}

	public Optional<ConfirmationToken> getToken(String token) {
		return confirmationTokenRepository.findByToken(token);
	}

	@Override
	public int setConfirmedAt(String token) {
		return confirmationTokenRepository.updateConfirmedAt(
				token, LocalDateTime.now());
	}
}
