package com.desafio.conexa.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Davi Maçana.
 *
 */
public class GenericErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private final LocalDateTime timestamp;
	private final int code;
	private final String status;
	private final String error;
	private final String codeErrorRandom;

	public GenericErrorResponse(LocalDateTime now, String message, int value, String name, String codeErrorRandom) {
		super();
		this.timestamp = now;
		this.error = message;
		this.code = value;
		this.status = name;
		this.codeErrorRandom = codeErrorRandom;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getCodeErrorRandom() {
		return codeErrorRandom;
	}
}
