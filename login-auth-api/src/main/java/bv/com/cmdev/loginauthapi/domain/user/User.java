package bv.com.cmdev.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;
    private String name;
    private String email;
    private String password;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "change_date")
    private LocalDateTime changeDate;
}
