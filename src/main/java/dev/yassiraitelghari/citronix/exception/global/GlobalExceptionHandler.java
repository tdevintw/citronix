package dev.yassiraitelghari.citronix.exception.global;

import dev.yassiraitelghari.citronix.exception.FarmWithUUIDNotFoundException;
import dev.yassiraitelghari.citronix.exception.FieldAreaPassedHalfOfFarmException;
import dev.yassiraitelghari.citronix.exception.PassTenFieldsPerFarmException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e){
        Map<String , String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error->{
            String fieldName = ((FieldError) error).getField() ;
            String message = error.getDefaultMessage() ;
            errors.put(fieldName , message);
        });
        return ResponseEntity.badRequest().body(errors) ;
    }

    @ExceptionHandler(FarmWithUUIDNotFoundException.class)
    public ResponseEntity<?> handleFarmUUIDNotFound(FarmWithUUIDNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(FieldAreaPassedHalfOfFarmException.class)
    public ResponseEntity<?> handleFieldAreaPassedHalfFarmSize(FieldAreaPassedHalfOfFarmException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(PassTenFieldsPerFarmException.class)
    public ResponseEntity<?> hanndeFarmReachedTopFieldSize(PassTenFieldsPerFarmException e){
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }
}
