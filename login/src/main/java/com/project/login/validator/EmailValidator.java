package com.project.login.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * @author RizaAdrian
 */
@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String s) {

		return true;
	}
}
