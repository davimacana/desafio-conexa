package com.desafio.conexa.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafio.conexa.utils.Messages;

/**
 * @author Davi Maçana.
 *
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private Messages mensagem;
	
	private static final Logger logger = Logger.getLogger(GlobalRestExceptionHandler.class.getCanonicalName());

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<GenericErrorResponse> badCredentialsExceptionHandler(Exception ex, WebRequest request)
			throws IOException {
		String randomError = String.valueOf(new Random().nextInt());
		logger.log(Level.SEVERE, randomError, ex);
		return new ResponseEntity<>(new GenericErrorResponse(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name(), randomError), HttpStatus.UNAUTHORIZED);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericErrorResponse> defaultExceptionHandler(Exception ex, WebRequest request)
			throws IOException {
		String randomError = String.valueOf(new Random().nextInt());
		logger.log(Level.SEVERE, randomError, ex);
		return new ResponseEntity<>(new GenericErrorResponse(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), randomError),
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundErrorException.class)
	public ResponseEntity<GenericErrorResponse> ExceptionNoResultHandler(Exception ex, WebRequest request)
			throws IOException {
		String randomError = String.valueOf(new Random().nextInt());
		logger.log(Level.SEVERE, randomError, ex);
		return new ResponseEntity<>(new GenericErrorResponse(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), randomError), HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ NotUniqueErrorException.class, GenericErrorRuleException.class })
	public ResponseEntity<GenericErrorResponse> ExceptionNoUniqueResultHandler(Exception ex, WebRequest request)
			throws IOException {
		String randomError = String.valueOf(new Random().nextInt());
		logger.log(Level.SEVERE, randomError, ex);
		return new ResponseEntity<>(new GenericErrorResponse(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), randomError), HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors = getErrors(ex);
		ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
		return new ResponseEntity<>(errorResponse, status);
	}

	private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status,
			List<ObjectError> errors) {
		return new ErrorResponse(mensagem.get("erro.generico.campos.invalidos"), status.value(), status.getReasonPhrase(),
				ex.getBindingResult().getObjectName(), errors);
	}

	private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
				.collect(Collectors.toList());
	}
}