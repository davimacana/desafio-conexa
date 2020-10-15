/**
 * 
 */
package com.desafio.conexa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.conexa.entity.BlackListToken;

/**
 * @author Davi Maçana
 *
 */
@Repository
public interface BlackListTokenRepository extends CrudRepository<BlackListToken, Long> {

	Optional<BlackListToken> findByToken(String token);		
}
