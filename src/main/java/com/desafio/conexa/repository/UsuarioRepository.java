/**
 * 
 */
package com.desafio.conexa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.conexa.entity.Usuario;

/**
 * @author Davi Maçana
 *
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	Optional<Usuario> findByUsuario(String usuario);
	
}
