package br.com.cmdev.springoauth.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Produto {
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
    private Boolean flAtivo;
}
