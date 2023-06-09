package br.com.cmdev.springdocopenapi.controller;

import br.com.cmdev.springdocopenapi.request.LoginRequest;
import br.com.cmdev.springdocopenapi.response.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest request){

        return new ResponseEntity<>(new LoginResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Logado com sucesso!"), HttpStatus.OK);
    }


}
