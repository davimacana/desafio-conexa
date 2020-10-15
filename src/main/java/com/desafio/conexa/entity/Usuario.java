package com.desafio.conexa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Davi Maçana
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	
	@Column
	private String usuario;
	
	@Column
    private String senha;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_medico")
	private Medico medico;
}
