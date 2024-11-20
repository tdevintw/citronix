package dev.yassiraitelghari.citronix.exception;

public class NoTreesPlantedInFieldException extends RuntimeException{
    public NoTreesPlantedInFieldException(){
        super("There is no trees in this field");
    }
}
