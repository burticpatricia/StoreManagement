package com.ing.store;

import com.ing.store.domain.entity.User;
import com.ing.store.domain.enums.Role;

public class UserPrecannedData {
    public static final Integer ID = 1;
    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";
    public static final Role USER_ROLE = Role.USER;

    public static User user = new User(ID, USERNAME, PASSWORD, USER_ROLE);
}
