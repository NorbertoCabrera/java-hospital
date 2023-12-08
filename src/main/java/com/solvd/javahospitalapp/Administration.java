package com.solvd.javahospitalapp;

import com.solvd.javahospitalapp.lambdasInterfaces.IFilePrintable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Administration <E extends Employee, D extends Department> implements IFilePrintable {

    private static final Logger logger = LogManager.getLogger(Administration.class);
    private E employee;

    private static final String FILE_PATH = "src/main/resources/EmployeesData.txt";


    private Set<E> employeesPayments = new LinkedHashSet<E>();//LinkedHashSet doesn't allow repeated values but keep each value's order
    private List<D> departments = new ArrayList<D>();

    public Administration() {}

    public void setEmployeePayment(E employee) {

        if (employee.getClass() == Doctor.class) {
            ((Doctor) employee).setSalary(50000);
           // logger.info("Doctor salary: "+((Doctor) employee).getSalary());
        } else if (employee.getClass()== Nurse.class) {
            ((Nurse) employee).setSalary(30000);
            //logger.info("nurse salary: "+((Nurse) employee).getSalary());
        }
        employeesPayments.add(employee);
        logger.info("lista de empleados pagados: " + employeesPayments);

    }
    public Set<E> getEmployeesPayments(){
        return employeesPayments;
    }
    public void setDepartments (D department){
        departments.add(department);
    }
    public List<D> getDepartments(){
        return departments;
    }



    // in this method we create a lambda expression to implement the method printToFile from our functional interface IFilePrintable
    @Override
    public void printToFile(){
        IFilePrintable lamdaPrint = ()->{
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                employeesPayments.forEach(employee -> {
                    try {
                        writer.write("Name: "+employee.getFirstName()+" Last name: "+ employee.getLastName()+" Salary: "+ employee.getSalary());
                        writer.newLine(); // Add a newline after each employee
                    } catch (IOException e) {
                        e.printStackTrace(); // Handle IOException
                    }
                });
            } catch (IOException e) {
                e.printStackTrace(); // Handle IOException
            }
        };
        lamdaPrint.printToFile();
    }


    //Filter doctors based on a condition "their experience"
    public List<Doctor> getExperiencedDoctors(List<Doctor> doctors){
        return doctors.stream()
                .filter(doctor -> doctor.getYearsOfExperience() > 5)
                .collect(Collectors.toList());
    }

    //map and get doctor's names
    public List<String> getDoctorsNames(List<Doctor> doctors){
        return doctors.stream()
                .map(Doctor::getFirstName)
                .collect(Collectors.toList());
    }

    //Sort doctors by years of experience
    public List<Doctor> getDoctorsByYearsOfExperience(List<Doctor> doctors){
        return doctors.stream()
                .sorted((doc1, doc2) -> Integer.compare(doc1.getYearsOfExperience(), doc2.getYearsOfExperience()))
                .collect(Collectors.toList());
    }


    public boolean isADoctorWithThisSpecialization(List<Doctor> doctors, String specialization){
               return doctors.stream()
                .anyMatch(doctor -> doctor.getSpecialization().equals(specialization));
    }

    public double getAverageExperienceOfDoctors(List<Doctor> doctors){
        return   doctors.stream()
                .mapToInt(Doctor::getYearsOfExperience)
                .average()
                .orElse(0.0);
    }

    //Concatenate the first names of all doctors into a single string
    public String doctorsNameConcatenation(List<Doctor> doctors){
                return doctors.stream()
                      .map(Doctor::getFirstName)
                      .collect(Collectors.joining(", "));
    }


    //Group doctors by their specialization
   public Map<String,List<Doctor>> getDoctorBySpecialization(List<Doctor> doctors){
              return  doctors.stream()
                     .collect(Collectors.groupingBy(Doctor::getSpecialization));
   }

   //print a result
   public void showExperiencedDoctors (List<Doctor> doctors){
        List<Doctor> experiencedDoctors = getDoctorsByYearsOfExperience(doctors);
        experiencedDoctors.forEach(System.out::println);
   }


}