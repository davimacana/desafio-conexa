/**
 * 
 */
package com.desafio.conexa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Davi Maçana
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BlackListToken implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idBlackList;

	@Column
	private String token;
}
