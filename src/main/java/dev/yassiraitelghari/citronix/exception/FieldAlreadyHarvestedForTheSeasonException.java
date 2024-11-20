package dev.yassiraitelghari.citronix.exception;

public class FieldAlreadyHarvestedForTheSeasonException extends RuntimeException{
    public FieldAlreadyHarvestedForTheSeasonException(){
        super("The field had been already harvested for the current season");
    }
}
