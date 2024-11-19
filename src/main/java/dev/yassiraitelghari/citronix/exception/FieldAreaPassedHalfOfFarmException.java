package dev.yassiraitelghari.citronix.exception;

public class FieldAreaPassedHalfOfFarmException extends RuntimeException{
    public FieldAreaPassedHalfOfFarmException(){
        super("Area can't pass half the size of the farm");
    }
}
