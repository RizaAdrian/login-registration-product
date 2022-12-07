package com.project.login.service;

import com.project.login.model.ConfirmationToken;

import java.util.Optional;

/**
 * @author RizaAdrian
 */

public interface ConfirmationTokenService {

	void saveConfirmationToken(ConfirmationToken token);

	Optional<ConfirmationToken> getToken(String token);

	int setConfirmedAt(String token);
}
