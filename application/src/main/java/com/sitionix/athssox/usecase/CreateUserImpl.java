package com.sitionix.athssox.usecase;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserImpl implements CreateUser {

    private final UserRepository userRepository;

    public CreateUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(final User user) {
        return  this.userRepository.execute(user);
    }
}
