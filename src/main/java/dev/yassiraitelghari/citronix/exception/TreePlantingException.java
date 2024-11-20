package dev.yassiraitelghari.citronix.exception;

public class TreePlantingException extends RuntimeException{
    public TreePlantingException(){
        super("The tree can be planted only between March and May Months");
    }
}
