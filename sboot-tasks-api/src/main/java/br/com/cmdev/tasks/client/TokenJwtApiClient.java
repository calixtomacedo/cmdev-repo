package br.com.cmdev.tasks.client;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;

public interface TokenJwtApiClient {

    @GetExchange("/cmdev/token/validate")
    public String validateToken(@RequestHeader("Authorization") String token);

    @GetExchange("/cmdev/user/email")
    public String findByEmail(@RequestHeader("Authorization") String token, @RequestHeader("email") String email);

}
