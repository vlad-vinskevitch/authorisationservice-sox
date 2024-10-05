package com.sitionix.athssox.repository;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.entity.UserEntity;
import com.sitionix.athssox.jpa.UserJpaRepository;
import com.sitionix.athssox.mapper.UserInfraMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserRepositoryImplTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserRepositoryImpl userRepositoryImpl(
                final UserJpaRepository userJpaRepository,
                final UserInfraMapper userInfraMapper) {
            return new UserRepositoryImpl(userJpaRepository, userInfraMapper);
        }
    }

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @MockBean
    public UserJpaRepository userJpaRepository;

    @MockBean
    public UserInfraMapper userInfraMapper;

    @Test
    void givenUser_thenCreateUser_thenReturnCreatedUser() {

        //given

        final User givenUser = Mockito.mock(User.class);
        final User createdUser = Mockito.mock(User.class);

        final UserEntity givenUserEntity = Mockito.mock(UserEntity.class);
        final UserEntity createdUserEntity = Mockito.mock(UserEntity.class);

        when(this.userInfraMapper.asUserEntity(givenUser)).thenReturn(givenUserEntity);
        when(this.userInfraMapper.asUser(createdUserEntity)).thenReturn(createdUser);
        when(this.userJpaRepository.save(givenUserEntity)).thenReturn(createdUserEntity);

        //when

        final User actual = this.userRepositoryImpl.createUser(givenUser);

        //then
        assertThat(actual).isEqualTo(createdUser);
    }

}