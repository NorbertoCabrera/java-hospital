package com.solvd.javahospitalapp;


//import Exceptions.InvalidTreatmentException;
//import Exceptions.NoDepartmentNameException;
//import Exceptions.PatientSymptomsException;
//import Interfaces.IHospitalStaff;
//import Interfaces.IMedicalProfessional;
//import Interfaces.ITreatment;
import com.solvd.javahospitalapp.Exceptions.InvalidTreatmentException;
import com.solvd.javahospitalapp.Exceptions.NoDepartmentNameException;
import com.solvd.javahospitalapp.Exceptions.PatientSymptomsException;
import com.solvd.javahospitalapp.Interfaces.IHospitalStaff;
import com.solvd.javahospitalapp.Interfaces.IMedicalProfessional;
import com.solvd.javahospitalapp.Interfaces.ITreatment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class Doctor extends Employee implements IMedicalProfessional, IHospitalStaff, ITreatment {


    private static final Logger logger = LogManager.getLogger(Doctor.class);

    private String specialization;
    private int salary;


    public Doctor(String firstName, String lastName, int yearsOfExperience, int salary, String specialization) {
        super(firstName, lastName, yearsOfExperience, salary);

        this.specialization = specialization;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void work(){
        logger.info("working as a doctor");
    }


    @Override
    public void diagnosePatient(Patient patient) throws PatientSymptomsException {
        if (patient.getSymptoms()=="bad"){

            patient.setCondition("ill");

        } else if (patient.getSymptoms().equals("very bad")) {
            patient.setCondition("very ill");
        }else patient.setCondition("not ill");
    }

    @Override
    public void prescribeMedication(Patient patient, Medication medication){
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
        logger.info("Specialization: "+this.specialization
                +" First name: "+this.getFirstName()
                +" Last name: "+this.getLastName());
    }


    public String getSurgeryDepartmentName (Surgery surgery){
        String surgeryDepartmentName = "";
        try {
            surgeryDepartmentName = surgery.getDepartmentName();
        }catch (NoDepartmentNameException ndne){
            logger.info(ndne.getMessage());
        }
        return surgeryDepartmentName;
    }
    @Override
    public void performTreatment(Patient patient){
        logger.info("perform treatment");
    }















    public String toString(){
        return "Specialization: " + specialization  + "First name: "+ getFirstName() + "Last name: " + getLastName();
    }


    public boolean equals (Doctor thatDoctor){

        return (this.getFirstName().equals(thatDoctor.getFirstName())
                &&this.getLastName().equals(thatDoctor.getLastName())
                &&this.specialization==thatDoctor.specialization);

    }



    @Override
    public int hashCode() {
        return Objects.hash(specialization);
    }
}