package br.com.cmdev.springoauth.repository;

import br.com.cmdev.springoauth.model.Produto;

import java.util.List;
import java.util.Optional;


public interface ProdutoRepository {

   public void create(Produto produto);

    public List<Produto> read();

    public Optional<Produto> readById(Integer id);

    public void update(Produto produto);

    public void delete(Integer id);

}
