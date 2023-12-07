package com.solvd.javahospitalapp.lambdasInterfaces;

import com.solvd.javahospitalapp.Employee;

public interface IFilePrintable <E extends Employee>{
    void printToFile();
}
