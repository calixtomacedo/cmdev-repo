package br.com.cmdev.springoauth.mappers;

import br.com.cmdev.springoauth.model.Produto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProdutoRowMapper implements RowMapper<Produto> {
    @Override
    public Produto map(ResultSet rs, StatementContext ctx) throws SQLException {
        return Produto.builder()
                .id(rs.getInt("id"))
                .nome(rs.getString("nome"))
                .descricao(rs.getString("descricao"))
                .valor(rs.getBigDecimal("valor"))
                .dataCriacao(rs.getTimestamp("dataCriacao").toLocalDateTime())
                .dataAlteracao(rs.getTimestamp("dataAlteracao") != null ? rs.getTimestamp("dataAlteracao").toLocalDateTime() : null)
                .flAtivo(rs.getBoolean("flAtivo"))
                .build();
    }
}
