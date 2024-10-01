package com.sitionix.athssox.mapper;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.entity.UserEntity;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserInfraMapperImplTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserInfraMapper userInfraMapper() {
            return new UserInfraMapperImpl();
        }
    }

    @Autowired
    private UserInfraMapper userInfraMapper;

    @Test
    void givenUser_whenAsUserEntity_thenReturnUserEntity() {
        //given
        final User given = this.getUser();
        final UserEntity expected = this.getUserEntity();

        //when
        final UserEntity actual = this.userInfraMapper.asUserEntity(given);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void givenUserEntity_whenAsUser_thenReturnUser() {
        //given
        final UserEntity given = this.getUserEntity();
        final User expected = this.getUser();

        //when
        final User actual = this.userInfraMapper.asUser(given);

        //then
        assertThat(actual).isEqualTo(expected);

    }


    private User getUser() {
        return User.builder()
                .id(1L)
                .userName("userName")
                .password("password")
                .build();
    }

    private UserEntity getUserEntity() {
        return UserEntity.builder()
                .id(1L)
                .userName("userName")
                .password("password")
                .build();
    }


}