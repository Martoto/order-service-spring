package com.dsalles.boilerplate.springboot.security.mapper;

import com.dsalles.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import com.dsalles.boilerplate.springboot.security.dto.RegistrationRequest;
import com.dsalles.boilerplate.springboot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
