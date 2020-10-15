/**
 * 
 */
package com.desafio.conexa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.conexa.entity.Paciente;

/**
 * @author Davi Maçana
 *
 */
@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

}
