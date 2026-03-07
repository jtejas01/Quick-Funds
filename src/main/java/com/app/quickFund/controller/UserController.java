package com.app.quickFund.controller;

import com.app.quickFund.dto.UserDto;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userResponse = userService.createUser(userDto);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
    @GetMapping("/userid/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto findUserById = userService.getById(id);
        return ResponseEntity.ok(findUserById);
    }
    @GetMapping("/phone/{phone}")
    public ResponseEntity<UserDto> getUserByPhone(@PathVariable String phone){
        UserDto getUserByPhone = userService.getByPhone(phone);
        return ResponseEntity.ok(getUserByPhone);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
         List<UserDto> allUsers = userService.gellAllUsers();
         return ResponseEntity.ok(allUsers);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUser(id,userDto);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
