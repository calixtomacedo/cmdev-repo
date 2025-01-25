package br.com.cmdev.user.controller;

import br.com.cmdev.user.domain.dto.UserRequest;
import br.com.cmdev.user.domain.dto.UserResponse;
import br.com.cmdev.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody @Valid UserRequest request) {
        UserResponse response = service.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registro criado com sucesso: "+response);
    }

    @GetMapping
    public  ResponseEntity getAllUsers() {
        List<UserResponse> response = service.getAllUsers();
        return ResponseEntity.ok(response);
    }

}
