package com.desafio.conexa.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.conexa.dto.AgendamentoDTO;
import com.desafio.conexa.dto.JwtResponseDTO;
import com.desafio.conexa.dto.UsuarioDTO;
import com.desafio.conexa.entity.BlackListToken;
import com.desafio.conexa.entity.Usuario;
import com.desafio.conexa.security.jwt.JwtProvider;
import com.desafio.conexa.service.BlackListTokenService;
import com.desafio.conexa.service.UsuarioService;
import com.desafio.conexa.utils.Messages;

import io.swagger.annotations.Api;

/**
 * @author Davi Maçana
 *
 */
@RestController
@ResponseStatus
@RequestMapping("/auth")
@Api(value = "Recurso de autenticação da aplicação")
public class AuthRestAPIs {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;
    
    @Autowired
    private BlackListTokenService blackListTokenService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
	private Messages messages;
    
	@PostMapping
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody UsuarioDTO login) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getSenha()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateJwtToken(authentication);
		
		Usuario usuario = usuarioService.findByUsuario(login.getUsuario()).orElseThrow( () -> new UsernameNotFoundException(messages.get("usuario.nao.encontrado")) );
		
		JwtResponseDTO jwtDTO = new JwtResponseDTO(jwt, 
				usuario.getMedico().getNome(), 
				usuario.getMedico().getEspecialidade(), 
				new ArrayList<>());
		
		usuario.getMedico().getAgendamentos().forEach(
				(agendamento) -> jwtDTO.getAgendamentos().add(new AgendamentoDTO(agendamento.getPaciente().getIdPaciente(), agendamento.getDataHora()))
		);
		
		return ResponseEntity.ok(jwtDTO);
	}

	@GetMapping
	public ResponseEntity<?> logoutUser(HttpServletRequest request) {

		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			authHeader = authHeader.replace("Bearer ", "");
		}
		blackListTokenService.addToken(authHeader);
		
		return ResponseEntity.ok(new BlackListToken(null, authHeader));
	}
}