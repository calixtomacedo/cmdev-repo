package br.com.cmdev.springoauth.controllers;

import br.com.cmdev.springoauth.model.Produto;
import br.com.cmdev.springoauth.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("springoauth/product")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Produto produto) throws SQLException {
        try {
            service.create(produto);
        } catch (Exception e){
            return new ResponseEntity("Erro ao salvar o produto.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> read() {
        List<Produto> produtos = service.read();
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> read(@PathVariable Integer id) {
        Optional<Produto> produto = service.read(id);
        if(produto.isPresent()){
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        service.update(produto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>("Registro Deletado com sucesso!", HttpStatus.OK);
    }

}
