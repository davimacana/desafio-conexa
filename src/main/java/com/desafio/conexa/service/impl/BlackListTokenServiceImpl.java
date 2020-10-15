/**
 * 
 */
package com.desafio.conexa.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.conexa.entity.BlackListToken;
import com.desafio.conexa.repository.BlackListTokenRepository;
import com.desafio.conexa.service.BlackListTokenService;

/**
 * @author Davi Maçana
 *
 */
@Service
public class BlackListTokenServiceImpl implements BlackListTokenService {

	@Autowired
	private BlackListTokenRepository blackListTokenRepository;

	@Override
	public Optional<BlackListToken> findByToken(String token) {
		return blackListTokenRepository.findByToken(token);
	}
	
	@Override
	public BlackListToken addToken(String token) {
		return blackListTokenRepository.save(new BlackListToken(null, token));
	}

}
