package com.chardy.springSisTurn.restcontroller;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.management.OperationsException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomControllerAdvise extends ResponseEntityExceptionHandler {

private static final Logger log = LoggerFactory.getLogger(RestControllerAdvice.class);
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(	MethodArgumentNotValidException ex,
																	HttpHeaders headers, 
																	HttpStatus status,
																	WebRequest request
																) {

		Map<String, Object> body = new LinkedHashMap<>();

		body.put("status", "error");
		body.put("code", status.value());
		
		// Get all errors
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x -> x.getField()+": "+x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("message", errors);
		
		return new ResponseEntity<>(body, headers, status);
	}	
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> NoSuchElementException(NoSuchElementException ex) {

		Map<String, Object> body = new HashMap<>();
		
		body.put("status", "error");
		body.put("code", HttpStatus.UNPROCESSABLE_ENTITY.value());
		body.put("message", ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> NullPointerException(NullPointerException ex) {
		
		/* Esta exepcion ocurre cuando:
		 * no existe org segun token enviado
		 */
		Map<String, Object> body = new HashMap<>();
		
		body.put("status", "error");
		body.put("code", HttpStatus.UNPROCESSABLE_ENTITY.value());
		body.put("message", ex.getMessage());
		
		return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	
	@ExceptionHandler(OperationsException.class)
	public ResponseEntity<Object> handleNotFoundException (OperationsException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", new Date());
		body.put("statusMessage", HttpStatus.NOT_FOUND);
		body.put("statusCode", HttpStatus.NOT_FOUND.value());
		body.put("errors", "El recurso no fue encontrado");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	//CommandAcceptanceException
	
	@ExceptionHandler(CommandAcceptanceException.class)
	public ResponseEntity<Object> handleCommandAcceptanceException (CommandAcceptanceException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", new Date());
		body.put("statusMessage", HttpStatus.INTERNAL_SERVER_ERROR);
		body.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
		body.put("errors", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


