package com.sitionix.athssox.mapper;

import com.app_afesox.athssox.api_first.dto.UserDTO;
import com.app_afesox.athssox.api_first.dto.UserRegistrationBody;
import com.app_afesox.athssox.api_first.dto.UserResponseDTO;
import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.domain.UserRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    @Mapping(source = "userName", target = "username")
    UserResponseDTO asUserResponseDTO(final User user);

    @Mapping(source = "username", target = "userName")
    User asUser(final UserDTO user);

    @Mapping(source ="username" , target = "userName")
    UserRegistration asUserRegistration(final UserRegistrationBody userRegistrationDTO);//TODO asUserRegistration
}
