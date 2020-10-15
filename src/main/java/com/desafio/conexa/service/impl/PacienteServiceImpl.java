/**
 * 
 */
package com.desafio.conexa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.conexa.dto.PacienteDTO;
import com.desafio.conexa.entity.Paciente;
import com.desafio.conexa.exception.NotFoundErrorException;
import com.desafio.conexa.repository.PacienteRepository;
import com.desafio.conexa.service.PacienteService;
import com.desafio.conexa.utils.GenericMapper;
import com.desafio.conexa.utils.Messages;

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
	public List<PacienteDTO> findAll() {
		List<Paciente> pacientes = new ArrayList<>();
		pacienteRepository.findAll().iterator().forEachRemaining(pacientes::add); 
		return GenericMapper.mapList(pacientes, PacienteDTO.class);
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
