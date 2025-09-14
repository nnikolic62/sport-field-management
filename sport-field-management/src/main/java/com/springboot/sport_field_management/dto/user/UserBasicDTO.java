package com.springboot.sport_field_management.dto.user;

import com.springboot.sport_field_management.enums.UserRole;

public record UserBasicDTO(
        Long id,
        String username,
        UserRole role
){}