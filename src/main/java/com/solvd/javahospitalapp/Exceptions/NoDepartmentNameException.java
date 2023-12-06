package com.solvd.javahospitalapp.Exceptions;

public class NoDepartmentNameException extends RuntimeException{
    public NoDepartmentNameException(String message){
        super(message);
    }
}
