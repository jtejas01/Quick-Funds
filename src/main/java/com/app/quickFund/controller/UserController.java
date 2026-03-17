package com.app.quickFund.controller;

import com.app.quickFund.dto.UserRequestDto;
import com.app.quickFund.dto.UserResponseDto;
import com.app.quickFund.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponse = userService.createUser(userRequestDto);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
    @GetMapping("/userid/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        UserResponseDto findUserById = userService.getById(id);
        return ResponseEntity.ok(findUserById);
    }
    @GetMapping("/phone/{phone}")
    public ResponseEntity<UserResponseDto> getUserByPhone(@PathVariable String phone){
        UserResponseDto getUserByPhone = userService.getByPhone(phone);
        return ResponseEntity.ok(getUserByPhone);
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
         List<UserResponseDto> allUsers = userService.gellAllUsers();
         return ResponseEntity.ok(allUsers);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        UserResponseDto updatedUser = userService.updateUser(id, userRequestDto);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
