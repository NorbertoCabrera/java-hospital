package com.solvd.javahospitalapp;
/*
import Exceptions.InvalidTreatmentException;
import Exceptions.PatientSymptomsException;
import Exceptions.PatientsConditionExceptions;
import Interfaces.IHospitalStaff;
import Interfaces.ILocation;
import Interfaces.IMedicalProfessional;
import Interfaces.ITreatment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/
import com.solvd.javahospitalapp.Exceptions.InvalidTreatmentException;
import com.solvd.javahospitalapp.Exceptions.PatientSymptomsException;
import com.solvd.javahospitalapp.Exceptions.PatientsConditionExceptions;
import com.solvd.javahospitalapp.Interfaces.IHospitalStaff;
import com.solvd.javahospitalapp.Interfaces.ILocation;
import com.solvd.javahospitalapp.Interfaces.IMedicalProfessional;
import com.solvd.javahospitalapp.Interfaces.ITreatment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Objects;

public class Nurse extends Employee implements ILocation, IMedicalProfessional, IHospitalStaff, ITreatment {

    private static final Logger logger = LogManager.getLogger(Nurse.class);

    private String hospitalArea;
    private int salary;



    public Nurse(String firsName, String lastName, int yearsOfExperience, int salary, String hospitalArea) {
        super(firsName,lastName,yearsOfExperience,salary);
        this.hospitalArea = hospitalArea;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getHospitalArea() {
        return hospitalArea;
    }

    public void setHospitalArea(String hospitalArea) {
        this.hospitalArea = hospitalArea;
    }

    public String tellLocation(){
        return ILocation.location_2;
    }


    @Override
    public void diagnosePatient(Patient patient) {
        //here we can see that this method throws an exception and handles it, this is not recommended!!
       try {
           if (patient == null){
               throw new InvalidTreatmentException("Classes.Patient is not present!!!");
           }
           if (patient.getSymptoms() == null){
               throw new PatientSymptomsException("no symptoms where found");
           }
           if (patient.getSymptoms()=="bad"){

               patient.setCondition("ill");

           } else if (patient.getSymptoms().equals("very bad")) {
               patient.setCondition("very ill");
           }else patient.setCondition("not ill");

       }catch (InvalidTreatmentException ite){
           logger.info("The diagnose can't be accomplished!! "+ ite.getMessage());
       }catch (PatientSymptomsException pse){
           logger.info("Classes.Patient's symptoms are not loaded" + pse.getMessage());
       }
    }
    @Override
    public void prescribeMedication(Patient patient, Medication medication){
        //here we can see that this method throws an exception and handles it, this is not recommended!!
        try {
            if (medication == null){
                throw new InvalidTreatmentException("There is no Classes.Medication available for the treatment!!!");
            }
            if (patient.getCondition().equals("ill")){
                medication.setDosage(50.54);
                medication.setName("Ibuprofen");
                patient.setMedication(medication);
            } else if (patient.getCondition().equals("very ill")) {
                medication.setName("penicillin");
                medication.setDosage(60.4);
                patient.setMedication(medication);
            }else {
                medication.setName("aspirin");
                medication.setDosage(50.2);
                patient.setMedication(medication);
            }


        }catch (InvalidTreatmentException e){
            logger.info("No medication available "+ e.getMessage());
        }

    }

    @Override
    public void performDuty(){
        work();
    }
    @Override
    public void getEmployeeInfo(){
        logger.info("Specialization: "+this.hospitalArea
                +" First name: "+this.getFirstName()
                +" Last name: "+this.getLastName());
    }





        @Override
    public void work(){
        logger.info("working as a nurse");
    }



    @Override
    public void performTreatment(Patient patient){
        logger.info("perform treatment");
    }



    public String obtainPatientSymptoms(Patient patient) {

        // in this method we are correctly handling and exception thrown in the Classes.Patient method 'getSymptoms()'

        String symptoms = "";
        try {
            symptoms = patient.getSymptoms();

        } catch (PatientSymptomsException pse) {
            logger.info(pse.getMessage());
        }
        return symptoms;
    }

    public String obtainPatientCondition(Patient patient){
        // in this method we are correctly handling and exception thrown in the Classes.Patient method 'getCondition()'
        String condition = "";

        try {
            condition = patient.getCondition();
        }catch (PatientsConditionExceptions pce){
            logger.info(pce.getMessage());
        }
        return condition;
    }



    // implementation of the toString, equals and hashCode methods
    public String toString(){
        return "First name: " + getFirstName() + "Last name: "+ getLastName() + "years of experience: " + getYearsOfExperience();
    }


    public boolean equals (Nurse thatNurse){

        return (this.getFirstName().equals(thatNurse.getFirstName())
                &&this.getLastName().equals(thatNurse.getLastName())
                &&this.getYearsOfExperience()==thatNurse.getYearsOfExperience()
                &&this.getSalary()==thatNurse.getSalary()
                &&this.hospitalArea.equals(thatNurse.hospitalArea));
    }




    public int hashCode() {
        return Objects.hash(hospitalArea);
    }
}
