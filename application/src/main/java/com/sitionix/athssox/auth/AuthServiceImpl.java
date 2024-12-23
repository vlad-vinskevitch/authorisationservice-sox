package com.sitionix.athssox.auth;

import com.sitionix.athssox.domain.UserLogin;
import com.sitionix.athssox.domain.UserRegistration;
import com.sitionix.athssox.domain.UserToken;
import com.sitionix.athssox.exception.UserAlreadyExistException;
import com.sitionix.athssox.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    @Override
    public void registrate(UserRegistration userRegistrationForm) {
        final boolean isEmailExist = this.userRepository.validateEmailExistence(userRegistrationForm.getEmail());
        if (isEmailExist) {
            throw new UserAlreadyExistException("User already exist");//TODO how todo exeption handler
        }

        final String hashPassword = this.encoder.encode(userRegistrationForm.getPassword());
        userRegistrationForm.setPassword(hashPassword);
        this.userRepository.registryUser(userRegistrationForm);

    }

    @Override
    public UserToken login(UserLogin userLoginForm) {
        return null;
    }

    private Boolean checkPasswordOnLogin(final String password) {
        return this.encoder.matches(password, this.encoder.encode(password));
    }
}
