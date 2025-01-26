package br.com.cmdev.user.service;

import br.com.cmdev.user.domain.User;
import br.com.cmdev.user.domain.dto.UserRequest;
import br.com.cmdev.user.domain.dto.UserResponse;
import br.com.cmdev.user.mapper.UserMapper;
import br.com.cmdev.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository repository;

    public UserResponse saveUser(UserRequest request) {
        User user = mapper.userRequestToUserMap(request);

        repository.save(user);

        UserResponse userResponse = mapper.userToUserResponseMap(user);
        return userResponse;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = repository.getAllUsers();
        List<UserResponse> response = mapper.userListToUserResponseListMap(users);
        return response;
    }
}
