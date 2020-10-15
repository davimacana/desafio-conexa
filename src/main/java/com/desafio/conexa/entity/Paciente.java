/**
 * 
 */
package com.desafio.conexa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Davi Maçana
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paciente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPaciente;
	
	@Column
	private String nome;
	
	@Column
	private String cpf;
	
	@Column
	private Integer idade;
	
	@Column
	private String telefone;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "paciente", fetch = FetchType.LAZY)
	private Set<Agendamento> agendamentos = new HashSet<>();
}
