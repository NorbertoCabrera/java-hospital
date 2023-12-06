package com.solvd.javahospitalapp.Interfaces;

//import Classes.Medication;
//import Classes.Patient;
//import Exceptions.PatientSymptomsException;

import com.solvd.javahospitalapp.Exceptions.PatientSymptomsException;
import com.solvd.javahospitalapp.Medication;
import com.solvd.javahospitalapp.Patient;

public  interface IMedicalProfessional {
    void diagnosePatient(Patient patient) throws PatientSymptomsException;
    void prescribeMedication(Patient patient, Medication medication);
}