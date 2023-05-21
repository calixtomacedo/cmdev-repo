package br.com.cmdev.sbootbeanvalidation.repository;

import br.com.cmdev.sbootbeanvalidation.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
