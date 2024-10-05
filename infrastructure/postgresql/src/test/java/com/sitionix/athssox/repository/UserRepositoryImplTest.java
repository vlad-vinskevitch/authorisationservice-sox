package com.sitionix.athssox.repository;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.entity.UserEntity;
import com.sitionix.athssox.jpa.UserJpaRepository;
import com.sitionix.athssox.mapper.UserInfraMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
        public UserRepositoryImpl userRepositoryImpl (
                final UserJpaRepository userJpaRepository,
                final UserInfraMapper userInfraMapper){
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
    void givenUser_thenCreateUser_thenReturnCreatedUser(){

        //given
        final Long givenUserId = null;
        final String givenUserPassword = "password";

        final Long createdUserId = 1L;
        final String createdUserPassword = "null";

        final User givenUser = getUser(givenUserId, givenUserPassword);
        final User createdUser = getUser(createdUserId, createdUserPassword);

        final UserEntity givenUserEntity = getUserEntity(givenUserId);
        final UserEntity createdUserEntity = getUserEntity(createdUserId);

        when(this.userInfraMapper.asUserEntity(givenUser)).thenReturn(givenUserEntity);
        when(this.userInfraMapper.asUser(createdUserEntity)).thenReturn(createdUser);
        when(this.userJpaRepository.save(givenUserEntity)).thenReturn(createdUserEntity);

        //when

        final User actual = this.userRepositoryImpl.createUser(givenUser);

        //then
        assertThat(actual).isEqualTo(createdUser);
    }

    private User getUser(Long id, String password){
        return User.builder()
                .id(id)
                .userName("userName")
                .password(password)
                .build();
    }
    private UserEntity getUserEntity(Long id){
        return UserEntity.builder()
                .id(id)
                .userName("userName")
                .password("password")
                .build();
    }

}