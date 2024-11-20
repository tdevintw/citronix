package dev.yassiraitelghari.citronix.exception;

public class SpaceBetweenTreesException extends RuntimeException{
    public SpaceBetweenTreesException(){
        super("The max number of trees by this field had been reached");
    }
}
