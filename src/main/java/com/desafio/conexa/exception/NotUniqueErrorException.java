package com.desafio.conexa.exception;

/**
 * @author Davi Maçana.
 *
 */
public class NotUniqueErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotUniqueErrorException(String msg) {
		super(msg);
	}

	public NotUniqueErrorException(String msg, Exception e) {
		super(msg + " because of " + e.toString());
	}
}
