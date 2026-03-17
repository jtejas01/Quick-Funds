package com.app.quickFund.services;

import com.app.quickFund.dto.UserRequestDto;
import com.app.quickFund.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getById(Long id);
    UserResponseDto getByPhone(String phone);
    List<UserResponseDto> gellAllUsers();
    UserResponseDto updateUser(Long id, UserRequestDto userRequestDto);
    void deleteUser(Long id);
}
