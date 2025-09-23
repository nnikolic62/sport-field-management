package com.springboot.sport_field_management.service;

import com.springboot.sport_field_management.dto.user.UserBasicDTO;
import com.springboot.sport_field_management.dto.user.UserRegistrationDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {

    UserBasicDTO register(UserRegistrationDAO credentials);
    List<UserBasicDTO> getAllUsers();
    Page<UserBasicDTO> getAllUsers(Pageable pageable);
}
