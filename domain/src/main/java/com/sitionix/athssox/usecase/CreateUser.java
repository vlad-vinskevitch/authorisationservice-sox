package com.sitionix.athssox.usecase;

import com.sitionix.athssox.domain.User;


public interface CreateUser {
    User execute(final User user);
}
