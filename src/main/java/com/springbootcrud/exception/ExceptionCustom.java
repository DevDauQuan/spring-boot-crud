package com.springbootcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionCustom {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
		// Log err

		return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getErrors());
	}

//	// handle exception do not declares
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public ErrorResponse handlerException(Exception ex, WebRequest req) {
//		// Log err
//
//		return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getErrors());
//	}

	@ExceptionHandler(ExistsException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse handlerExistsException(ExistsException ex, WebRequest req) {
		// Log err

		return new ErrorResponse(HttpStatus.CONFLICT, ex.getErrors());
	}

}
