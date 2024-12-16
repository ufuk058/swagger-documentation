package com.swagger.controller;

import com.swagger.dto.UserDTO;
import com.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "User CRUD Operations")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @Operation(summary = "Read All Users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    @Operation(summary = "Create a new User")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDTO));
    }
}
