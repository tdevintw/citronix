package dev.yassiraitelghari.citronix.exception;

public class HarvestDetailWithUUIDNotFoundException extends RuntimeException{
    public HarvestDetailWithUUIDNotFoundException(){
        super("There is no Tree harvest assigned with this id");
    }
}
