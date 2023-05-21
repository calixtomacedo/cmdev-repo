package br.com.cmdev.sbootbeanvalidation.service.impl;

import br.com.cmdev.sbootbeanvalidation.exceptions.GlobalNotFoundException;
import br.com.cmdev.sbootbeanvalidation.model.Usuario;
import br.com.cmdev.sbootbeanvalidation.model.dto.UsuarioRequest;
import br.com.cmdev.sbootbeanvalidation.repository.UsuarioRepository;
import br.com.cmdev.sbootbeanvalidation.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario salva(UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .genero(request.getGenero())
                .idade(request.getIdade())
                .telefone(request.getTelefone())
                .email(request.getEmail())
                .senha(request.getSenha())
                .build();

        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listaTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> pesquisa(Integer id) throws GlobalNotFoundException {
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isPresent()){
            return usuario;
        }
        throw new GlobalNotFoundException("Nenhum usuário encontrado para o id: "+id);
    }

}
