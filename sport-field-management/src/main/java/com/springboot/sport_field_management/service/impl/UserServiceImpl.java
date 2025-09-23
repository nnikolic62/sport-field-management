package com.springboot.sport_field_management.service.impl;

import com.springboot.sport_field_management.dto.user.UserBasicDTO;
import com.springboot.sport_field_management.dto.user.UserRegistrationDAO;
import com.springboot.sport_field_management.entity.User;
import com.springboot.sport_field_management.repo.UserRepository;
import com.springboot.sport_field_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserBasicDTO register(UserRegistrationDAO credentials) {
        User savedUser = userRepository.save(new User(credentials.username(), encoder.encode(credentials.password()), credentials.role()));

        return new UserBasicDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getRole());
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
