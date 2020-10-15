package com.desafio.conexa.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Davi Maçana
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDTO {
	
	private String token;
	private String medico;
	private String especialidade;
	private List<AgendamentoDTO> agendamentos = new ArrayList<>();

}