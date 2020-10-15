package com.desafio.conexa.exception;

/**
 * @author Davi Maçana.
 *
 */
public class ObjectError {

	private final String message;
	private final String field;
	private final Object parameter;

	public ObjectError(String defaultMessage, String field2, Object rejectedValue) {
		super();
		this.message = defaultMessage;
		this.field = field2;
		this.parameter = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public String getField() {
		return field;
	}

	public Object getParameter() {
		return parameter;
	}
}
