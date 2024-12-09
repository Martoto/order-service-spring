package com.dsalles.boilerplate.springboot.security.service;

import com.dsalles.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.dsalles.boilerplate.springboot.security.dto.RegistrationRequest;
import com.dsalles.boilerplate.springboot.security.dto.RegistrationResponse;
import com.dsalles.boilerplate.springboot.model.User;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
