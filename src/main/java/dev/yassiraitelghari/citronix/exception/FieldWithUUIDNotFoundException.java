package dev.yassiraitelghari.citronix.exception;

public class FieldWithUUIDNotFoundException extends RuntimeException{
    public FieldWithUUIDNotFoundException(){
        super("There is no field with this uuid");
    }
}
