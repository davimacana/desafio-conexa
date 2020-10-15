/**
 * 
 */
package com.desafio.conexa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.conexa.Messages;
import com.desafio.conexa.dto.PacienteDTO;
import com.desafio.conexa.entity.Paciente;
import com.desafio.conexa.exception.NotFoundErrorException;
import com.desafio.conexa.repository.PacienteRepository;
import com.desafio.conexa.service.PacienteService;

/**
 * @author Davi Maçana
 *
 */
@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private Messages messages;
	
	@Override
	public Iterable<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente add(PacienteDTO paciente) {
		return pacienteRepository.save(new Paciente(null, paciente.getNome(), paciente.getCpf(), paciente.getIdade(), paciente.getTelefone(), null));
	}

	@Override
	public Paciente findById(String id) throws NumberFormatException, NotFoundErrorException {
		return pacienteRepository.findById(Long.parseLong(id)).orElseThrow( () -> new NotFoundErrorException(messages.get("paciente.nao.encontrado")) );
	}

}
