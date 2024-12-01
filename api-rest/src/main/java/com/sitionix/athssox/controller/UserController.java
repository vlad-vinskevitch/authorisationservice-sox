package com.sitionix.athssox.controller;

import com.app_afesox.athssox.api_first.api.UserApi;
import com.app_afesox.athssox.api_first.dto.*;
import com.sitionix.athssox.auth.AuthService;
import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.domain.UserRegistration;
import com.sitionix.athssox.mapper.UserApiMapper;
import com.sitionix.athssox.usecase.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final CreateUser createUser;

    private final UserApiMapper userDtoMapper;

    private final AuthService authService;

    @Override
    public ResponseEntity<UserResponseDTO> createUser(@Valid UserDTO userDTO) {

        final User user = this.userDtoMapper.asUser(userDTO);
        final User createdUser = this.createUser.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.userDtoMapper.asUserResponseDTO(createdUser));
    }

    @Override
    public ResponseEntity<UserLoginResponse> login(@Valid UserLoginBody userLoginBody) {
        return UserApi.super.login(userLoginBody);
    }

    @Override
    public ResponseEntity<Void> registration(@Valid UserRegistrationBody userRegistrationBody) {//TODO Rename UserRegistrationBody to UserRegistrationDTO
        final UserRegistration registration = this.userDtoMapper.asRegistration(userRegistrationBody);
        return null
                //ResponseEntity.status(HttpStatus.CREATED);//TODO make with void without response body
    }
}
