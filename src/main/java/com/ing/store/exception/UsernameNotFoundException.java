package com.ing.store.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsernameNotFoundException extends RuntimeException {

    public static final String USER_WITH_GIVEN_USERNAME_NOT_FOUND = "User with given username not found.";

    @Override
    public String getMessage() {
        return USER_WITH_GIVEN_USERNAME_NOT_FOUND;
    }

    public UsernameNotFoundException() {
        super(USER_WITH_GIVEN_USERNAME_NOT_FOUND);
    }
}
