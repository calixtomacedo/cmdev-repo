package br.com.cmdev.tasks.config;

import br.com.cmdev.tasks.client.TokenJwtApiClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenJwtApiClient jwtApiClient;

    public SecurityFilter(TokenJwtApiClient jwtApiClient) {
        this.jwtApiClient = jwtApiClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJwt = this.recoverToken(request);
        if (tokenJwt != null) {
            var email = jwtApiClient.validateToken(tokenJwt);
            var user = jwtApiClient.findByEmail(tokenJwt, email);
            System.out.println(user);
            //var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            //SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;

        }
        return authHeader.replace("Bearer ", "");
    }
}
