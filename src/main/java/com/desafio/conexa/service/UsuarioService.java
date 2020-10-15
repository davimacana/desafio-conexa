/**
 * 
 */
package com.desafio.conexa.service;

import java.util.Optional;

import com.desafio.conexa.entity.Usuario;

/**
 * @author Davi Maçana
 *
 */
public interface UsuarioService {
	
	Optional<Usuario> findByUsuario(String usuario);
}
