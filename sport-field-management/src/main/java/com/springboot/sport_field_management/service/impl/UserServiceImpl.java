package com.springboot.sport_field_management.service.impl;

import com.springboot.sport_field_management.dto.user.UserBasicDTO;
import com.springboot.sport_field_management.entity.User;
import com.springboot.sport_field_management.repo.UserRepository;
import com.springboot.sport_field_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserBasicDTO> getAllUsers() {
        List<User> dbUsers = userRepository.findAll();

        return dbUsers.stream().map(user -> new UserBasicDTO(user.getId(), user.getUsername(), user.getRole())).toList();
    }

    @Override
    public Page<UserBasicDTO> getAllUsers(Pageable pageable) {
        Page<User> dbUsers = userRepository.findAll(pageable);

        return dbUsers.map(user -> new UserBasicDTO(user.getId(), user.getUsername(), user.getRole()));
    }
}
