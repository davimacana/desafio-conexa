/**
 * 
 */
package com.desafio.conexa.service;

import java.util.List;

import com.desafio.conexa.dto.PacienteDTO;
import com.desafio.conexa.entity.Paciente;
import com.desafio.conexa.exception.NotFoundErrorException;

/**
 * @author Davi Maçana
 *
 */
public interface PacienteService {

	List<PacienteDTO> findAll(); 
	Paciente add(PacienteDTO paciente);
	Paciente findById(String id) throws NumberFormatException, NotFoundErrorException;
}
