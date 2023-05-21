package br.com.cmdev.sbootbeanvalidation.service;

import br.com.cmdev.sbootbeanvalidation.exceptions.GlobalNotFoundException;
import br.com.cmdev.sbootbeanvalidation.model.Usuario;
import br.com.cmdev.sbootbeanvalidation.model.dto.UsuarioRequest;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario salva(UsuarioRequest request);

    List<Usuario> listaTodos();

   Optional<Usuario> pesquisa(Integer id) throws GlobalNotFoundException;

}
