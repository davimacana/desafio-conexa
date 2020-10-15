/**
 * 
 */
package com.desafio.conexa.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author Davi Maçana
 *
 */
@Data
public class PacienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(min=3, max = 180)
	private String nome;
	
	@NotBlank
    @Size(min = 11, max = 11)
	private String cpf;
	
	@NotBlank
	private Integer idade;
	
	@NotBlank
	private String telefone;
}
