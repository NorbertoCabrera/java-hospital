package com.solvd.javahospitalapp;
/*
import Exceptions.PatientSymptomsException;
import Exceptions.PatientsConditionExceptions;
import Interfaces.ILocation;
*/
import com.solvd.javahospitalapp.Exceptions.PatientSymptomsException;
import com.solvd.javahospitalapp.Exceptions.PatientsConditionExceptions;
import com.solvd.javahospitalapp.Interfaces.ILocation;

import java.util.Objects;

public class Patient extends Person implements ILocation {

    private String condition;
    private String symptoms;

    private Medication medication;


    public Patient(String firstName,String lastName, String condition, String symptoms) {
        super(firstName,lastName);
        this.condition = condition;
        this.symptoms = symptoms;
    }



    public String getCondition() throws PatientsConditionExceptions {
        // in this method we throw a custom exception that will be handled in the calling method in the class 'Classes.Nurse'
        if (condition == null){throw new PatientsConditionExceptions("condition was not found!! ");}
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSymptoms() throws PatientSymptomsException {
        // in this method we throw a custom exception that will be handled in the calling method in the class 'Classes.Nurse'
        if (symptoms == null){ throw new PatientSymptomsException("symptoms not found");}
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String tellLocation(){
        return ILocation.location_1;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }





    public String toString(){
        return "First name" + getFirstName() + "Last name: " + getLastName() + "Condition: " + getCondition();
    }

    public boolean equals (Patient thatPatient){

        return (this.getFirstName().equals(thatPatient.getFirstName())
                &&this.getLastName().equals(thatPatient.getLastName())
                &&this.condition==thatPatient.condition);

    }

    public int hashCode(){
        return Objects.hash(condition);
    }
}
