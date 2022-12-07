package com.project.login.mapper;

import com.project.login.dto.UserDTO;
import com.project.login.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * @author RizaAdrian
 */
@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User sourceToDestination(UserDTO userDTO);

	UserDTO destinationToSource(User user);
}
