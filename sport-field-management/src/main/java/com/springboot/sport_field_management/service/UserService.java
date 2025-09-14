package com.springboot.sport_field_management.service;

import com.springboot.sport_field_management.dto.user.UserBasicDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    List<UserBasicDTO> getAllUsers();
    Page<UserBasicDTO> getAllUsers(Pageable pageable);
}
