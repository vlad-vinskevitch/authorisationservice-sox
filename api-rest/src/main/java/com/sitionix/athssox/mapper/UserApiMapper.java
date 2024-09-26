package com.sitionix.athssox.mapper;

import com.app_afesox.athssox.api_first.dto.UserDTO;
import com.app_afesox.athssox.api_first.dto.UserResponseDTO;
import com.sitionix.athssox.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    UserResponseDTO asUserResponseDTO (final User user);

    User asUser(final UserDTO user);
}
