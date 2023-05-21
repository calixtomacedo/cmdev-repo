package br.com.cmdev.sbootbeanvalidation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBUSUARIO")
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private String genero;
    private Integer idade;
    private String telefone;
    private String email;
    private String senha;
}
