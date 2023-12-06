package com.solvd.javahospitalapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Lab extends Department {

    private static final Logger logger = LogManager.getLogger(Lab.class);

    private String type;
    private int numberOfStudies;


    static{
        //here would be the initialization of the lab's database with information about the patient's studies
        // with this static block we can set/refresh the number of studies every time the class lab is loaded.

          logger.info("Classes.Patient's Studies from lab");
    }

    public Lab(String name, String director, String type) {
        super(name,director);
        this.type = type;
    }


    public String getType() {
        return type;
    }
    // public void setNumberOfStudies(){}  we will set this method with the database information
    public int getNumberOfStudies(){return numberOfStudies;}
    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return "Name" + getName() + "Director: " + getDirector() + "Type: " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lab lab = (Lab) o;
        return numberOfStudies == lab.numberOfStudies && Objects.equals(type, lab.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, numberOfStudies);
    }
}
