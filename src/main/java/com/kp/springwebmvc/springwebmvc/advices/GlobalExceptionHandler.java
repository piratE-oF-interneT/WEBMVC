package com.kp.springwebmvc.springwebmvc.advices;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;

import com.kp.springwebmvc.springwebmvc.exceptions.*;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler{
	



	@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<ApiResponse<?>> getException(ResourceNotFoundException exception){
		
//		apiError.setMessage(exception.getMessage());
//		apiError.setStatus(HttpStatus.NOT_FOUND);
		
//		ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage());
		
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		System.out.println("resource not found error");
		return buildErrorApiResponse(apiError);
		
		
	}
	


//	@ExceptionHandler(BadRequestException.class)
//	public ResponseEntity<ApiResponse<?>> handleBadRequest(BadRequestException exception){
//		
//		ApiError apiError = new ApiError();
//		apiError.setMessage("bad request exception has occured");
//		apiError.setStatus(HttpStatus.BAD_REQUEST);
//		
//		return buildErrorApiResponse(apiError);		
//	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ApiResponse<?>> handleInternalError(Exception exception ){
//		ApiError apiError = new ApiError();
//		apiError.setMessage(exception.getMessage());
//		apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//		
//		return buildErrorApiResponse(apiError);
//		
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<ApiResponse<?>> handleIllegalArgumentException(MethodArgumentNotValidException exception){
		
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
		
		System.out.println("hit method argument error");
		
		return buildErrorApiResponse(apiError);
	}
	
//	private ApiError apiError;
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	
	public ResponseEntity<ApiResponse<?>>  handleMethodNotAllowed(HttpRequestMethodNotSupportedException exception){
		
		ApiError apiError = new ApiError();
		apiError.setMessage("method not allowed");
		apiError.setStatus(HttpStatus.METHOD_NOT_ALLOWED);
		
		
		
		return buildErrorApiResponse(apiError);
		
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	
	public ResponseEntity<ApiResponse<?>>  handleMethodMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception){
		
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		
		
		
		
		
		return buildErrorApiResponse(apiError);
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	
public ResponseEntity<ApiResponse<?>> constarintVoilate(ConstraintViolationException exception){
		
	
		
		
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		
		
		System.out.println("constraint violation");
		
		return buildErrorApiResponse(apiError);
		
		
		
		
	}
	
	private ResponseEntity<ApiResponse<?>> buildErrorApiResponse(ApiError apiError) {
		// TODO Auto-generated method stub
		
		
	
	
		
		return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
	}

}
