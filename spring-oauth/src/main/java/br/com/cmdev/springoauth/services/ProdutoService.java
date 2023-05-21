package br.com.cmdev.springoauth.services;

import br.com.cmdev.springoauth.model.Produto;
import br.com.cmdev.springoauth.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void create(Produto produto) {
        produto.setDataCriacao(LocalDateTime.now());
        repository.create(produto);
    }

    public List<Produto> read() {
        return repository.read();
    }

    public Optional<Produto> read(Integer id) {
        return repository.readById(id);
    }

    public void update(Produto produto) {
        produto.setDataAlteracao(LocalDateTime.now());
        repository.update(produto);
    }

    public void delete(Integer id) {
       repository.delete(id);
    }
}
