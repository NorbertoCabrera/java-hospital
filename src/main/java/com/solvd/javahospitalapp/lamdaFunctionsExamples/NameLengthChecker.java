package com.solvd.javahospitalapp.lamdaFunctionsExamples;

import java.util.function.Function;

//function<T,R> lambda
public class NameLengthChecker {
    public NameLengthChecker() {}

    public  Function<String, Integer> employeeNameLength = employeeName -> employeeName.length();
}
