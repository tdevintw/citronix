package dev.yassiraitelghari.citronix.exception;

public class NoFarmsWithTotalFieldAreaLessThen4000Exception extends RuntimeException{
    public NoFarmsWithTotalFieldAreaLessThen4000Exception(){
        super("There is no farm where its fields area total is less then 4000");
    }
}
