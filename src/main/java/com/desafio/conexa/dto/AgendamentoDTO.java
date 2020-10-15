/**
 * 
 */
package com.desafio.conexa.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class AgendamentoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPaciente;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss")
	private Calendar dataHoraAtendimento;
}
