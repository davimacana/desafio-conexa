package com.desafio.conexa.exception;

/**
 * @author Davi Maçana.
 *
 */
public class GenericErrorRuleException extends Exception {

	private static final long serialVersionUID = 1L;

	public GenericErrorRuleException(String msg) {
		super(msg);
	}

	public GenericErrorRuleException(String msg, Exception e) {
		super(msg + " because of " + e.toString());
	}
}
