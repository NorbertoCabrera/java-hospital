package com.solvd.javahospitalapp.lamdaFunctionsExamples;

//predicate lambda function

import java.util.function.Predicate;

public class GoodSalary {
    private int salaryThreshold;

    public GoodSalary(int salaryThreshold) {
        this.salaryThreshold = salaryThreshold;
    }

    public Predicate<Integer> isGoodSalary = employeeSalary -> employeeSalary > salaryThreshold;
}
