package com.sitionix.athssox.auth;

import com.sitionix.athssox.domain.UserLogin;
import com.sitionix.athssox.domain.UserRegistration;
import com.sitionix.athssox.domain.UserToken;

public interface AuthService {

    void registrate (final UserRegistration userRegistrationForm);

    UserToken login(final UserLogin userLoginForm);

}
