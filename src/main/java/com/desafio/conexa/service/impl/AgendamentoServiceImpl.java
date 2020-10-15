/**
 * 
 */
package com.desafio.conexa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.conexa.entity.Agendamento;
import com.desafio.conexa.repository.AgendamentoRepository;
import com.desafio.conexa.service.AgendamentoService;

/**
 * @author Davi Maçana
 *
 */
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Override
	public Agendamento addAgendamento(Agendamento agendamento) {
		return agendamentoRepository.save(agendamento);
	}

}
