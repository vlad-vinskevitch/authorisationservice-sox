package com.sitionix.athssox.repository;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.domain.UserRegistration;
import com.sitionix.athssox.entity.UserEntity;
import com.sitionix.athssox.jpa.UserJpaRepository;
import com.sitionix.athssox.mapper.UserInfraMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    private final UserInfraMapper userInfraMapper;

    @Override
    public User createUser(final User user) {

        final UserEntity userEntity = this.userInfraMapper.asUserEntity(user);
        final UserEntity createdUser = this.userJpaRepository.save(userEntity);

        return this.userInfraMapper.asUser(createdUser);
    }

    @Override
    public Boolean validateEmailExistence(String email) {
        return this.userJpaRepository.existsByEmail(email);
    }

    @Override
    public void registryUser(UserRegistration userRegistrationForm) {
        final UserEntity userEntity = this.userInfraMapper.asUserEntity(userRegistrationForm);
        this.userJpaRepository.save(userEntity);
    }


}
