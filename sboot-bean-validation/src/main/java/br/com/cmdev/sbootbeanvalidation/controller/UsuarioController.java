package br.com.cmdev.sbootbeanvalidation.controller;

import br.com.cmdev.sbootbeanvalidation.exceptions.GlobalNotFoundException;
import br.com.cmdev.sbootbeanvalidation.model.Usuario;
import br.com.cmdev.sbootbeanvalidation.model.dto.UsuarioRequest;
import br.com.cmdev.sbootbeanvalidation.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/app/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> salva(@RequestBody @Valid UsuarioRequest request) {
        return new ResponseEntity<>(service.salva(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listaTodos() {
        return ResponseEntity.ok(service.listaTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> pesquisa(@PathVariable Integer id) throws GlobalNotFoundException {
        return new ResponseEntity<>(service.pesquisa(id), HttpStatus.OK);
    }

}
