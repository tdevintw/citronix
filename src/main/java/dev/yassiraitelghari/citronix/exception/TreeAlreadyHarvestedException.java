package dev.yassiraitelghari.citronix.exception;

public class TreeAlreadyHarvestedException extends RuntimeException{
    public TreeAlreadyHarvestedException(){
        super("This Tree had been already harvested in this season");
    }
}
