package com.sitionix.athssox.usecase;

import com.sitionix.athssox.domain.User;
import com.sitionix.athssox.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CreateUserImplTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public CreateUserImpl createUserImpl(final UserRepository userRepository) {
            return new CreateUserImpl(userRepository);
        }
    }

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private CreateUserImpl createUser;


    @AfterEach
    public void tearDown (){
        verifyNoMoreInteractions(
                this.userRepository
        );
    }

    @Test
    void givenUser_whenCreateUser_thenReturnCreatedUser() {

        //given

        final User givenUser = Mockito.mock(User.class);
        final User createdUser = Mockito.mock(User.class);

        when(this.userRepository.createUser(givenUser)).thenReturn(createdUser);

        //when

        final User actual = this.createUser.execute(givenUser);

        //then

        assertThat(actual).isEqualTo(createdUser);

        //verify

        verify(this.userRepository).createUser(givenUser);
    }

}