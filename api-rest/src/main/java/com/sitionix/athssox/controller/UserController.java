package com.sitionix.athssox.controller;

import com.app_afesox.athssox.api_first.api.UserApi;
import com.app_afesox.athssox.api_first.dto.UserDTO;
import com.app_afesox.athssox.api_first.dto.UserResponseDTO;
import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.mapper.UserApiMapper;
import com.sitionix.athssox.usecase.CreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController implements UserApi {

    private final CreateUser createUser;

    private final UserApiMapper userDtoMapper;

    public UserController(CreateUser createUser, UserApiMapper userDtoMapper) {
        this.createUser = createUser;
        this.userDtoMapper = userDtoMapper;
    }


    @Override
    public ResponseEntity<UserResponseDTO> createUser(@Valid UserDTO userDTO) {

        final User user = this.userDtoMapper.asUser(userDTO);
        final User createdUser = this.createUser.execute(user);
        return ResponseEntity.ok(this.userDtoMapper.asUserResponseDTO(createdUser));
    }
}
