package com.solvd.javahospitalapp;

public abstract class Employee extends Person {
    protected int yearsOfExperience;
    protected int salary;


    public Employee(String firstName, String lastName, int yearsOfExperience,int salary) {

        super(firstName,lastName);
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }


    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public abstract void work();

    public boolean equals (Employee thatEmployee){

            return (this.getFirstName().equals(thatEmployee.getFirstName())&&this.getLastName().equals(thatEmployee.getLastName())&&this.getYearsOfExperience() == thatEmployee.getYearsOfExperience()&&this.getSalary()== thatEmployee.getSalary());

 }

    @Override
    public String toString() {
        return "Classes.Employee{" +
                "yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
