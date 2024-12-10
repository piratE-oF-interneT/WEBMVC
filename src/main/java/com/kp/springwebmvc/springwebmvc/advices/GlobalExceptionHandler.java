package com.kp.springwebmvc.springwebmvc.advices;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@RestControllerAdvice
public class GlobalExceptionHandler{
	



	@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<ApiError> getException(ResourceNotFoundException exception){
		
//		apiError.setMessage(exception.getMessage());
//		apiError.setStatus(HttpStatus.NOT_FOUND);
		
//		ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage());
		
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiError>(apiError,HttpStatus.NOT_FOUND);
		
		
	}
	
//	@ExceptionHandler(BadRequestException.class)
//	public ResponseEntity<ApiError> handleBadRequest(BadRequestException exception){
//		
//		ApiError apiError = new ApiError();
//		apiError.setMessage(exception.getMessage());
//		apiError.setStatus(HttpStatus.BAD_REQUEST);
//		
//		return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
//		
//	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ApiError> handleInternalError(Exception exception ){
//		ApiError apiError = new ApiError();
//		apiError.setMessage(exception.getMessage());
//		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//		
//		return new ResponseEntity<ApiError>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<ApiError> handleIllegalArgumentException(MethodArgumentNotValidException exception){
		
		List<String> errors = exception
							  .getBindingResult()
							  .getAllErrors()
							  .stream()
							  .map(error-> error.getDefaultMessage())
							  .collect(Collectors.toList());
		
		ApiError apiError = new ApiError();
		apiError.setMessage("illegal argument --> invald input");
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setSubError(errors);
		
		return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
	}

}
