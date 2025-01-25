package br.com.cmdev.user.domain;

import br.com.cmdev.user.utils.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long idUser;
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private Boolean isActive;
    private LocalDateTime creationDate;
    private LocalDateTime changeDate;

}