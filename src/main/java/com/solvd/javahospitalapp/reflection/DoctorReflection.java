package com.solvd.javahospitalapp.reflection;

import com.solvd.javahospitalapp.Administration;
import com.solvd.javahospitalapp.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DoctorReflection{
    private static final Logger logger = LogManager.getLogger(DoctorReflection.class);

    private Class<Doctor> doctorClass = Doctor.class;


    public void showDoctorClassFields(){
        for (Field field:doctorClass.getDeclaredFields()){
            logger.info("Name: " + field.getName() +
                    ", Type: " + field.getType() +
                    ", Modifiers: " + field.getModifiers());
        }
    }

    public void showInformationAboutConstructors(){
        for (Constructor<?> constructor : doctorClass.getDeclaredConstructors()) {
            logger.info("Name: " + constructor.getName() +
                    ", Parameters: " + constructor.getParameterCount() +
                    ", Modifiers: " + constructor.getModifiers());
        }
    }

    public void showInformationAboutMethods(){
        for (Method method : doctorClass.getDeclaredMethods()) {
            logger.info("Name: " + method.getName() +
                    ", Return Type: " + method.getReturnType() +
                    ", Parameters: " + method.getParameterCount() +
                    ", Modifiers: " + method.getModifiers());
        }
    }

    public void createInstanceDefaultConstructor() throws Exception{
        Doctor doctor = doctorClass.getDeclaredConstructor().newInstance();
        logger.info("Instance created with reflection: "+doctor);
    }

    public void setYearsOfExperienceField() throws Exception{
        Field yearsOfExperienceField = doctorClass.getDeclaredField("yearsOfExperience");
        yearsOfExperienceField.setAccessible(true);
        yearsOfExperienceField.set(doctorClass, 10);
    }

    public void invokeMethod()throws Exception{
        Method introduceMethod = doctorClass.getDeclaredMethod("performTreatment");
        introduceMethod.invoke(doctorClass);
    }

    public void invokeMethodWithReturnValue()throws Exception{
        Method getSurgeryDepartmentName = doctorClass.getDeclaredMethod("getSurgeryDepartmentName");
        String fullName = (String) getSurgeryDepartmentName.invoke(doctorClass);
        logger.info("Surgery Department Name: " + fullName);
    }

}
