/**
 * 
 */
package com.desafio.conexa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.conexa.entity.Agendamento;

/**
 * @author Davi Maçana
 *
 */
@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long> {
		
}
