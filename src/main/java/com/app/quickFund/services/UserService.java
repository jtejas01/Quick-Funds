package com.app.quickFund.services;

import com.app.quickFund.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getById(Long id);
    UserDto getByPhone(String phone);
    List<UserDto> gellAllUsers();
    UserDto updateUser(Long id,UserDto userDto);
    void deleteUser(Long id);
}
