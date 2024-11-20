package dev.yassiraitelghari.citronix.exception;

public class TreeWithUUIDNotFoundException extends RuntimeException{

    public TreeWithUUIDNotFoundException(){
        super("There is no tree with this id");
    }
}
