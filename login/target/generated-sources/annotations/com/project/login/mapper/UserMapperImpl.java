package com.project.login.mapper;

import com.project.login.dto.UserDTO;
import com.project.login.model.User;
import com.project.login.model.UserRole;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-02T18:08:46+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User sourceToDestination(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDTO.getName() );
        user.setUsername( userDTO.getUsername() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setUserRole( userDTO.getUserRole() );

        return user;
    }

    @Override
    public UserDTO destinationToSource(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        String username = null;
        String email = null;
        String password = null;
        UserRole userRole = null;

        name = user.getName();
        username = user.getUsername();
        email = user.getEmail();
        password = user.getPassword();
        userRole = user.getUserRole();

        UserDTO userDTO = new UserDTO( name, username, email, password, userRole );

        return userDTO;
    }
}
