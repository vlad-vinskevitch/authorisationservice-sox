package com.sitionix.athssox.repository;

import com.sitionix.athssox.domain.User;

public interface UserRepository {
    User execute(final User user);
}
