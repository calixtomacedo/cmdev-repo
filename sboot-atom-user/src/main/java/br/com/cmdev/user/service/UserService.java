package br.com.cmdev.user.service;

import br.com.cmdev.user.domain.User;
import br.com.cmdev.user.domain.dto.UserRequest;
import br.com.cmdev.user.domain.dto.UserResponse;
import br.com.cmdev.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    List<UserResponse> allUsers = new ArrayList<>();

    public UserResponse saveUser(UserRequest request) {
        User user = mapper.userRequestToUserMap(request);

        UserResponse userResponse = mapper.userToUserResponseMap(user);
        allUsers.add(userResponse);
        return userResponse;
    }

    public List<UserResponse> getAllUsers() {

        return this.allUsers;
    }
}
