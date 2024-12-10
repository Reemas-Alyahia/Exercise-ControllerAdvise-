package com.example.capston2.ControllerAdvice;

import com.example.capston2.ApiResponse.ApiExption;
import com.example.capston2.ApiResponse.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.net.BindException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLIntegrityConstraintViolationException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = ApiExption.class)
    public ResponseEntity ApiExption(ApiExption e){
        String masssege=e.getMessage();
        return ResponseEntity.status(400).body(masssege);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String masssege=e.getMessage();
        return ResponseEntity.status(400).body(masssege);
    }


    // Server Validation Exception
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    // Server Validation Exception
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> ConstraintViolationException(ConstraintViolationException e) {
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }


    // SQL Constraint Ex:(Duplicate) Exception
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    // wrong write SQL in @column Exception
    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class )
    public ResponseEntity<ApiResponse> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        String msg=e.getMessage();
        return ResponseEntity.status(200).body(new ApiResponse(msg));
    }


    // Method not allowed Exception
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    // Json parse Exception
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }

    // TypesMisMatch Exception
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }
    //NoResourceFoundException
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String masssege=e.getMessage();
        return ResponseEntity.status(400).body(masssege);
    }


    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException e) {
        String msg =  e.getMessage();
        return ResponseEntity.status(403).body(new ApiResponse(msg));
    }


    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        String msg =e.getMessage();
        return ResponseEntity.status(404).body(new ApiResponse(msg));
    }


    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<ApiResponse> handleBindException(BindException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponse(msg));
    }


    @ExceptionHandler(value = OptimisticLockException.class)
    public ResponseEntity<ApiResponse> handleOptimisticLockException(OptimisticLockException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(409).body(new ApiResponse(msg));
    }

}
