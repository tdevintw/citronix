package dev.yassiraitelghari.citronix.exception.global;

import dev.yassiraitelghari.citronix.exception.*;
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
    public ResponseEntity<?> handleFarmReachedTopFieldSize(PassTenFieldsPerFarmException e){
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }

    @ExceptionHandler(FieldAreaPassLeftFarmSize.class)
    public ResponseEntity<?> handleFieldPassLeftFarmSize(FieldAreaPassLeftFarmSize e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(FieldWithUUIDNotFoundException.class)
    public ResponseEntity<?> handleFieldUUIDNotFound(FieldWithUUIDNotFoundException e){
        return  ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(TreePlantingException.class)
    public ResponseEntity<?> handlePlantingMonthNotAccurate(TreePlantingException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    @ExceptionHandler(SpaceBetweenTreesException.class)
    public ResponseEntity<?> handleSpaceNotAvailableForPlanting(SpaceBetweenTreesException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(TreeWithUUIDNotFoundException.class)
    public ResponseEntity<?> handleTreeWithUUIDNotFound(TreeWithUUIDNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(TreeAlreadyHarvestedException.class)
    public ResponseEntity<?> handleTreeHadBeenHarvested(TreeAlreadyHarvestedException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
