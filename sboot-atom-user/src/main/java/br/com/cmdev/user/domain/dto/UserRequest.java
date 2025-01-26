package br.com.cmdev.user.domain.dto;

import br.com.cmdev.user.utils.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @NotBlank @Size(min = 3, max = 150)
        String name,

        @NotBlank @Email @Size(min = 6, max = 100)
        String email,

        @NotBlank @Size(min = 10, max = 255)
        String password,

        UserRole role
        ) {
}
