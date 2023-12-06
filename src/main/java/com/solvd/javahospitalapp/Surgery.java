package com.solvd.javahospitalapp;

/*import Exceptions.NoDepartmentDirectorException;
import Exceptions.NoDepartmentNameException;
import Interfaces.IDepartmentInformation;
*/
import com.solvd.javahospitalapp.Exceptions.NoDepartmentDirectorException;
import com.solvd.javahospitalapp.Exceptions.NoDepartmentNameException;
import com.solvd.javahospitalapp.Interfaces.IDepartmentInformation;

import java.util.Objects;

public class Surgery extends Department implements IDepartmentInformation {

    private final int MAX_CAPACITY = 5;

    public Surgery(String name,String director, int maxCapacity) {
        super(name,director);

    }



    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }



    @Override
    public String getDepartmentName() throws NoDepartmentNameException {

        if (name == null){throw new NoDepartmentNameException("No department name was found!! ");}

        return name;
    }
    @Override
    public String getDepartmentDirector() throws NoDepartmentDirectorException {
        if (director == null){ throw new NoDepartmentDirectorException("No director was found!! ");}
        return this.getDirector();
    }

















    public String toString(){
        return "Name" + getName() + "Director: " + getDirector() + "Max Capacity: " + getMaxCapacity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surgery surgery = (Surgery) o;
        return MAX_CAPACITY == surgery.MAX_CAPACITY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDirector(),getName());
    }
}

