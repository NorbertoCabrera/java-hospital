package com.solvd.javahospitalapp.lamdaFunctionsExamples;

import java.util.function.Supplier;

//Supplier<T>
public class SupplierExample {
    Supplier<Double> randomNumber = () -> Math.random();
}
