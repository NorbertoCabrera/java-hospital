package com.solvd.javahospitalapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Administration <E extends Employee, D extends Department> {

    private static final Logger logger = LogManager.getLogger(Administration.class);
    private E employee;


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
}