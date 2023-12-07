package com.solvd.javahospitalapp;

import com.solvd.javahospitalapp.lambdasInterfaces.IFilePrintable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Administration <E extends Employee, D extends Department> implements IFilePrintable {

    private static final Logger logger = LogManager.getLogger(Administration.class);
    private E employee;

    private static final String FILE_PATH = "src/main/resources/EmployeesData.txt";


    private Set<E> employeesPayments = new LinkedHashSet<E>();//LinkedHashSet doesn't allow repeated values but keep each value's order
    private List<D> departments = new ArrayList<D>();

    public Administration() {

    }

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
}