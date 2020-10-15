/**
 * 
 */
package com.desafio.conexa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.conexa.dto.PacienteDTO;
import com.desafio.conexa.exception.NotFoundErrorException;
import com.desafio.conexa.service.PacienteService;

import io.swagger.annotations.Api;

/**
 * @author Davi Maçana
 *
 */
@RestController
@RequestMapping("/pacientes")
@Api(value = "Recurso de pacientes da aplicação")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(pacienteService.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) throws NotFoundErrorException {
		return ResponseEntity.ok(pacienteService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody PacienteDTO paciente) {
		return ResponseEntity.ok(pacienteService.add(paciente));
	}
}
