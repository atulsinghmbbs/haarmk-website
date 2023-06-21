package com.haarmk.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler{


	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> myIllegalArgumentException(IllegalArgumentException me) {
		
		ErrorDetails err = new ErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getMessage());
		
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
//	@ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request){
//		ErrorDetails err = new ErrorDetails();
//		err.setMessage(e.getMessage());
//        return ResponseEntity.status(403).body(err);
//    }

//	@ExceptionHandler(SignatureException.class)
//	public ResponseEntity<ErrorDetails> handleSignatureException(SignatureException e, HttpServletRequest request){
//		ErrorDetails err = new ErrorDetails();
//		err.setTimestamp(LocalDateTime.now());
//		err.setMessage(e.getMessage());
//		err.setDetails(request.getContextPath());
//		return ResponseEntity.status(403).body(err);
//	}
//	
//	@ExceptionHandler(JwtException.class)
//	public ResponseEntity<ErrorDetails> handleJwtException(JwtException e, HttpServletRequest request){
//		ErrorDetails err = new ErrorDetails();
//		err.setTimestamp(LocalDateTime.now());
//		err.setMessage(e.getMessage());
//		err.setDetails(request.getContextPath());
//		return ResponseEntity.status(403).body(err);
//	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myInvalidDataExpHandler(MethodArgumentNotValidException me) {
		
		ErrorDetails err = new ErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
		
		
	}



	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myAnyExpHandler(Exception ie,WebRequest req){
		
		
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
			
	
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
					
	}

	

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> myAnyExpHandler(UserException ie,WebRequest req){
		
		
		ErrorDetails err = new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	

	
	
	
	
}
