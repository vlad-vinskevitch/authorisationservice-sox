package com.sitionix.athssox.auth;

import com.sitionix.athssox.domain.UserLogin;
import com.sitionix.athssox.domain.UserRegistration;
import com.sitionix.athssox.domain.UserToken;

public interface AuthService {

    void registratre (final UserRegistration userRegistrationForm);//TODO

    UserToken login(final UserLogin userLoginForm);

}
