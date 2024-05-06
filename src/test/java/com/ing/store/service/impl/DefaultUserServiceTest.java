package com.ing.store.service.impl;

import com.ing.store.UserPrecannedData;
import com.ing.store.domain.entity.User;
import com.ing.store.exception.UsernameNotFoundException;
import com.ing.store.repository.UserRepository;
import com.ing.store.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService sut = new DefaultUserService(userRepository);

    @Test
    void should_returnUser_given_existingUserWithGivenUsername_when_loadUserByUsername() {
        //GIVEN
        User existingUser = UserPrecannedData.user;
        String username = UserPrecannedData.USERNAME;
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(existingUser));

        //WHEN
        UserDetails result = sut.loadUserByUsername(username);

        //THEN
        assertThat(result).isEqualTo(existingUser);
    }

    @Test
    void should_throwUsernameNotFoundException_given_noUserWithGivenUsername_when_loadUserByUsername() {
        //GIVEN
        String username = UserPrecannedData.USERNAME;
        when(userRepository.findByUsername(username)).thenThrow(UsernameNotFoundException.class);

        //WHEN & THEN
        assertThrows(UsernameNotFoundException.class, () -> sut.loadUserByUsername(username));
    }
}
