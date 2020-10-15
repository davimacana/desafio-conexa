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
public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Size(min=3, max = 60)
	private String usuario;
	
	@NotBlank
    @Size(min = 6, max = 40)
	private String senha;
}
