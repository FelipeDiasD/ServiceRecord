package br.com.felipedias.ServiceRecord.errors;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundHandler(ResourceNotFoundException e, HttpServletRequest request){
       String error = "Resource not found";
       HttpStatus status = HttpStatus.NOT_FOUND;

       StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getServletPath());

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}
