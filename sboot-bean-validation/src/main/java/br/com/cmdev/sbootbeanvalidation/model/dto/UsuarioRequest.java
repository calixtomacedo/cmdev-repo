package br.com.cmdev.sbootbeanvalidation.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {


    @NotBlank(message = "não deve estar em branco")
    @Size(min = 2, max = 254, message = "o tamanho deve estar entre 2 e 254")
    private String nome;

    @NotBlank(message = "não deve estar em branco")
    @Size(min = 8, max = 10, message = "o tamanho deve estar entre 8 e 10")
    private String genero;

    @Min(value = 18, message = "deve ser maior ou igual a 18")
    @Max(value = 99, message = "deve ser menor ou igual a 99")
    private Integer idade;

    @NotBlank(message = "não deve estar em branco")
    @Size(min = 10, max = 20, message = "o tamanho deve estar entre 10 e 20")
    private String telefone;

    @Email(message = "deve ser um endereço de e-mail válido")
    @Size(min = 10, max = 100, message = "o tamanho deve estar entre 10 e 100")
    private String email;

    @NotBlank(message = "não deve estar em branco")
    @Size(min = 6, max = 100, message = "o tamanho deve estar entre 6 e 100")
    private String senha;
}
