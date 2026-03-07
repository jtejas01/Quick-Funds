package com.app.quickFund.services;

import com.app.quickFund.dto.UserDto;
import com.app.quickFund.entities.UserEntity;
import com.app.quickFund.exception.ErrorCode;
import com.app.quickFund.exception.custom.CustomException;
import com.app.quickFund.repositories.UserRepository;
import com.app.quickFund.services.helper.EntityFinderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private EntityFinderService entityFinderService;

    @Override
    public UserDto createUser(UserDto userDto) {
       UserEntity user =  modelMapper.map(userDto,UserEntity.class);
       UserEntity savedUser = userRepository.save(user);
       return modelMapper.map(savedUser,UserDto.class);

    }

    @Override
    public UserDto getById(Long id) {
        UserEntity user = entityFinderService.getUserById(id);
        return modelMapper.map(user,UserDto.class);
    }

    @Override
    public UserDto getByPhone(String phone) {
        UserEntity user = entityFinderService.getUserByPhone(phone);
        return modelMapper.map(user,UserDto.class) ;
    }

    @Override
    public List<UserDto> gellAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(user-> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserEntity existingUser = userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.ID_NOT_FOUND));
        modelMapper.map(userDto,existingUser);
        UserEntity updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser,UserDto.class);
    }
    @Override
    public void deleteUser(Long id) {
        UserEntity user = entityFinderService.getUserById(id);
        userRepository.delete(user);
    }
}
