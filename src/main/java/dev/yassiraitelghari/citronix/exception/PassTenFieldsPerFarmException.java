package dev.yassiraitelghari.citronix.exception;

public class PassTenFieldsPerFarmException extends RuntimeException{
    public PassTenFieldsPerFarmException(){
        super("Farm already have 10 fields");
    }
}
