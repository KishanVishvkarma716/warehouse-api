package com.example.warehouse.service.impl;

import com.example.warehouse.dto.mapper.UserMapper;
import com.example.warehouse.dto.request.UserRegistrationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;
import com.example.warehouse.entity.Admin;
import com.example.warehouse.entity.Staff;
import com.example.warehouse.entity.User;
import com.example.warehouse.enums.UserRole;
import com.example.warehouse.exceptions.UnSupportedUserRoleException;
import com.example.warehouse.exceptions.UserNotFoundByEmailException;
import com.example.warehouse.exceptions.UserNotFoundByIdException;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.security.AuthUtils;
import com.example.warehouse.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.warehouse.security.AuthUtils.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserResponse addUser(UserRegistrationRequest urr) {

            UserRole role = urr.userRole();
            User user;
            if (role == UserRole.STAFF) {
                user = userMapper.userToEntity(urr, new Staff());
            } else if (role == UserRole.ADMIN) {
                user = userMapper.userToEntity(urr, new Admin());
            } else {
                throw new IllegalArgumentException("Unsupported role: " + role);
            }
          String  passwordEncod= passwordEncoder.encode(user.getPassword());
            user.setPassword(passwordEncod);
            userRepository.save(user);
            return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest request, String userId) {
       User exUser =getCurrentUser()
               .map(userName -> userRepository.findByEmail(userName).orElseThrow(()->new UserNotFoundByEmailException("User not found ")))
               .orElseThrow(()-> new UnSupportedUserRoleException("user not supported"));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundByIdException("User Not Found!!"));
       user = userMapper.requestToEntity(request,user);
       userRepository.save(user);
       return userMapper.userToResponse(user);
    }

    @Override
    public UserResponse findUserById() {
        return getCurrentUser()
               .map(userName -> userRepository.findByEmail(userName).orElseThrow(()->new UserNotFoundByEmailException("User not found ")))
                .map(userMapper::userToResponse)
             .orElseThrow(() -> new UserNotFoundByIdException("User Not Found!!"));

    }

    @Override
    public UserResponse deleteUserById(String userId) {
       User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundByIdException("UserId Not Found!!"));
        userRepository.delete(user);
        return userMapper.userToResponse(user);
    }
}
