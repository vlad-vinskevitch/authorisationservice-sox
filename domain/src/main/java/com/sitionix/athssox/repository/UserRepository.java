package com.sitionix.athssox.repository;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.domain.UserRegistration;

public interface UserRepository {

    User createUser(final User user);

    Boolean validateEmailExistence (final String email );

    void registryUser(final UserRegistration userRegistrationForm);
}
