package com.sitionix.athssox.mapper;

import com.app_afesox.athssox.api_first.dto.UserDTO;
import com.app_afesox.athssox.api_first.dto.UserResponseDTO;
import com.sitionix.athssox.domain.User;
import org.junit.jupiter.api.Disabled;
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
class UserApiMapperTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserApiMapper userApiMapper() {
            return new UserApiMapperImpl();
        }
    }

    @Autowired
    private UserApiMapper userApiMapper;

    @Test
    void givenUser_whenAsUserResponseDTO_thenReturnUserResponseDTO() {
        //given
        final Long givenUsedId = 1L;

        final User given = this.getUser(givenUsedId);
        final UserResponseDTO expected = this.getUserResponseDTO();

        //when
        final UserResponseDTO actual = this.userApiMapper.asUserResponseDTO(given);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void givenUserDTO_whenAsUser_thenReturnUser() {
        //given
        final UserDTO given = this.getUserDTO();
        final User expected = this.getUser(null);

        //when
        final User actual = this.userApiMapper.asUser(given);

        //given
        assertThat(actual).isEqualTo(expected);

    }

    private UserResponseDTO getUserResponseDTO() {
        return new UserResponseDTO()
                .username("username")
                .id(1L);
    }

    private UserDTO getUserDTO() {
        return new UserDTO("username", "password");
    }

    private User getUser(final Long id) {
        return User.builder()
                .id(id)
                .userName("username")
                .password("password")
                .build();
    }

}