package dev.yassiraitelghari.citronix.exception;

public class FarmWithUUIDNotFoundException extends RuntimeException{
    public FarmWithUUIDNotFoundException(){
        super("There is no farm with this id");
    }
}
