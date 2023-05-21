package br.com.cmdev.springoauth.config;

import br.com.cmdev.springoauth.infrastruture.database.JdbiProdutoRepository;
import br.com.cmdev.springoauth.repository.ProdutoRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;
@Configuration
public class JdbiConfiguration {

    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugin, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy dataSourceProxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbi = Jdbi.create(dataSourceProxy);
        jdbiPlugin.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);
        return jdbi;
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin(){
        return new SqlObjectPlugin();
    }

    @Bean
    public ProdutoRepository produtoRepository(Jdbi jdbi) {
        return jdbi.onDemand(JdbiProdutoRepository.class);
    }

}
