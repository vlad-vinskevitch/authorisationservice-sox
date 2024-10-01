package com.sitionix.athssox.usecase;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserImpl implements CreateUser {

    private final UserRepository userRepository;

    @Override
    public User execute(final User user) {

        return this.userRepository.createUser(user);
    }
}
