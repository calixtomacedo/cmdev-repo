package bv.com.cmdev.loginauthapi.controller;

import bv.com.cmdev.loginauthapi.domain.user.User;
import bv.com.cmdev.loginauthapi.dto.LoginRequest;
import bv.com.cmdev.loginauthapi.dto.LoginResponse;
import bv.com.cmdev.loginauthapi.dto.RegisterRequest;
import bv.com.cmdev.loginauthapi.infra.security.TokenService;
import bv.com.cmdev.loginauthapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request) {
        User user = this.repository.findByEmail(request.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(request.password(), user.getPassword())) {
            String token = this.tokenService.geneteToken(user);
            return ResponseEntity.ok(new LoginResponse(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {
        if(this.repository.findByEmail(request.email()).isEmpty()){
            User user = new User();
            user.setName(request.name());
            user.setEmail(request.email());
            user.setPassword(passwordEncoder.encode(request.password()));
            user.setIsActive(true);
            user.setCreateDate(LocalDateTime.now());
            this.repository.save(user);

            String token = this.tokenService.geneteToken(user);
            return ResponseEntity.ok(new LoginResponse(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}
