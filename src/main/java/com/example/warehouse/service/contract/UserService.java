package com.example.warehouse.service.contract;

import com.example.warehouse.dto.request.UserRegistrationRequest;
import com.example.warehouse.dto.request.UserRequest;
import com.example.warehouse.dto.response.UserResponse;


public interface UserService {
    UserResponse addUser(UserRegistrationRequest user);

    UserResponse updateUser(UserRequest request, String id);

    UserResponse findUserById();

    UserResponse deleteUserById(String userId);
}
