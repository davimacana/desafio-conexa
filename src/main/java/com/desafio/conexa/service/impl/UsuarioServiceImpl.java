/**
 * 
 */
package com.desafio.conexa.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.conexa.entity.Usuario;
import com.desafio.conexa.repository.UsuarioRepository;
import com.desafio.conexa.service.UsuarioService;

/**
 * @author Davi Maçana
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
	}

}
