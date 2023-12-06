package com.solvd.javahospitalapp.Exceptions;

public class NoDepartmentDirectorException extends RuntimeException{
    public NoDepartmentDirectorException(String message){
        super(message);
    }
}
