/**
 * 
 */
package com.desafio.conexa.service;

import java.util.Optional;

import com.desafio.conexa.entity.BlackListToken;

/**
 * @author Davi Maçana
 *
 */
public interface BlackListTokenService {
	
	Optional<BlackListToken> findByToken(String token);

	BlackListToken addToken(String token);
}
