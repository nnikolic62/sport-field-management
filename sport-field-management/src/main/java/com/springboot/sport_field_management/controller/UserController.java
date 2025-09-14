package com.springboot.sport_field_management.controller;

import com.springboot.sport_field_management.dto.user.UserBasicDTO;
import com.springboot.sport_field_management.entity.User;
import com.springboot.sport_field_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Page<UserBasicDTO>> getAll(@RequestParam(required = false) Integer pageNumber,
                                             @RequestParam(required = false) Integer pageSize,
                                             @RequestParam(required = false) String sortBy,
                                             @RequestParam(required = false) String sortDir){
        if(pageNumber != null && pageSize != null){
            Pageable pageable;

            if(sortBy != null && sortDir != null){
                Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
                pageable = PageRequest.of(pageNumber, pageSize, sort);
            }else{
                pageable = PageRequest.of(pageNumber, pageSize);
            }
            Page<UserBasicDTO> users = userService.getAllUsers(pageable);
            return ResponseEntity.ok(users);
        }else{
            List<UserBasicDTO> users = userService.getAllUsers();
            Page<UserBasicDTO> page = new PageImpl<>(users);
            return ResponseEntity.ok(page);
        }
    }

}
