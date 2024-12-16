package com.swagger.service;

import com.swagger.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();
    UserDTO create(UserDTO userDTO);
}
