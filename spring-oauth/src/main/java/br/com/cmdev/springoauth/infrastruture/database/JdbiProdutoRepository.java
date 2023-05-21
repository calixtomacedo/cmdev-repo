package br.com.cmdev.springoauth.infrastruture.database;

import br.com.cmdev.springoauth.model.Produto;
import br.com.cmdev.springoauth.repository.ProdutoRepository;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@UseClasspathSqlLocator
public interface JdbiProdutoRepository extends ProdutoRepository {

    @Override
    @SqlUpdate
    public void create(@BindBean Produto produto);

    @Override
    @SqlQuery
    public List<Produto> read();

    @Override
    @SqlQuery
    public Optional<Produto> readById(Integer id);

    @Override
    @SqlUpdate
    public void update(@BindBean Produto produto);

    @Override
    @SqlUpdate
    public void delete(Integer id);

}
