package com.desafio.conexa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.conexa.Messages;
import com.desafio.conexa.entity.Usuario;
import com.desafio.conexa.repository.UsuarioRepository;
import com.desafio.conexa.security.jwt.UserPrinciple;

/**
 * @author Davi Maçana
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
	private Messages messages;
    
    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
    	Usuario user = usuarioRepository.findByUsuario(usuario).orElseThrow(() -> new UsernameNotFoundException(messages.get("usuario.nao.encontrado")));
    	return UserPrinciple.build(user);
    }
}