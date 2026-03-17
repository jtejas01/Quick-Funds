package com.app.quickFund.services;

import com.app.quickFund.dto.UserRequestDto;
import com.app.quickFund.dto.UserResponseDto;
import com.app.quickFund.entities.UserEntity;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.UserRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final EntityFinderService entityFinderService;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
       UserEntity user =  modelMapper.map(userRequestDto,UserEntity.class);
       user.setCreatedAt(LocalDateTime.now());
       UserEntity savedUser = userRepository.save(user);
       return modelMapper.map(savedUser, UserResponseDto.class);

    }

    @Override
    public UserResponseDto getById(Long id) {
        UserEntity user = entityFinderService.getUserById(id);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto getByPhone(String phone) {
        UserEntity user = entityFinderService.getUserByPhone(phone);
        return modelMapper.map(user, UserResponseDto.class) ;
    }

    @Override
    public List<UserResponseDto> gellAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(user-> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        UserEntity existingUser = entityFinderService.getUserById(id);
        modelMapper.map(userRequestDto,existingUser);
        UserEntity updatedUser = userRepository.save(existingUser);
        updatedUser.setUpdatedAt(LocalDateTime.now());
        return modelMapper.map(updatedUser, UserResponseDto.class);
    }
    @Override
    public void deleteUser(Long id) {
        UserEntity user = entityFinderService.getUserById(id);
        userRepository.delete(user);
    }
}
