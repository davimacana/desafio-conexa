package com.desafio.conexa.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Davi Maçana.
 *
 */
public class ErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	
	private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ObjectError> errors;
    
	public ErrorResponse(String string, int value, String reasonPhrase, String objectName2, List<ObjectError> errors2) {
		super();
		this.message = string;
		this.code = value;
		this.status = reasonPhrase;
		this.objectName = objectName2;
		this.errors = errors2;
	}
	public String getMessage() {
		return message;
	}
	public int getCode() {
		return code;
	}
	public String getStatus() {
		return status;
	}
	public String getObjectName() {
		return objectName;
	}
	public List<ObjectError> getErrors() {
		return errors;
	}
}
