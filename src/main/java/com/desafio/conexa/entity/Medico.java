/**
 * 
 */
package com.desafio.conexa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author Davi Maçana
 *
 */
@Data
@Entity
public class Medico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idMedico;
	
	@Column
	private String nome;
	
	@Column
	private String especialidade;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "medico", fetch = FetchType.LAZY)
	private List<Agendamento> agendamentos = new ArrayList<>();
}
