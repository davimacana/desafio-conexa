package com.desafio.conexa.exception;

/**
 * @author Davi Maçana.
 *
 */
public class NotFoundErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundErrorException(String msg) {
		super(msg);
	}

	public NotFoundErrorException(String msg, Exception e) {
		super(msg + " because of " + e.toString());
	}
}
