package com.rajan.eta.Exceptions;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ItemAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> itemAlreadyExistExceptionHandler(ItemAlreadyExistException e, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setStatusCode(HttpStatus.CONFLICT.value());
		errorDetails.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ExpenseException.class)
	public ResponseEntity<ErrorDetails> expenseExceptionHandler(ExpenseException ee, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(ee.getMessage());
		errorDetails.setDescription(wr.getDescription(false));
		errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorDetails> methodExceptionHandler(MethodArgumentTypeMismatchException me, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(me.getMessage());
		errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorDetails.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(UserException e, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorDetails.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception e, WebRequest wr){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.setDescription(wr.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> bodyMap = new HashMap<>();
		bodyMap.put("timeStamp", LocalDateTime.now());
		bodyMap.put("statusCode", HttpStatus.BAD_REQUEST.value());
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(ref->ref.getDefaultMessage()).collect(Collectors.toList());
		bodyMap.put("message", errors.get(0));
		return new ResponseEntity<Object>(bodyMap,HttpStatus.BAD_REQUEST);
	}
}
