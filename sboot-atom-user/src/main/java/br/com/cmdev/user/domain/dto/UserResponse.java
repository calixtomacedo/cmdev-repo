package br.com.cmdev.user.domain.dto;

public record UserResponse(

        Long idUser,
        String name,
        String email,
        String password,
        String role,
        Boolean isActive,
        String creationDate,
        String changeDate

) {
}
