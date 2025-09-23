package com.springboot.sport_field_management.dto.user;

import com.springboot.sport_field_management.enums.UserRole;

public record UserRegistrationDAO(
        String username,
        String password,
        UserRole role
) {
}
