package com.solvd.javahospitalapp.Interfaces;

//this interface was create assuming the hospital only receives patients from the declared locations
public interface ILocation{

    String location_1 = "san francisco";
    String location_2 = "california";
    String location_3 = "washington";

    String tellLocation();

}
