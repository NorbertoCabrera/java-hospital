package com.solvd.javahospitalapp;

/*import Interfaces.IDepartmentInformation;
*/
import com.solvd.javahospitalapp.Interfaces.IDepartmentInformation;

import java.util.Objects;

public class Pharmacy extends Department implements IDepartmentInformation {

    private int itemCount;

    public Pharmacy(String name, String director, int itemCount) {
        super(name,director);
        this.itemCount = itemCount;
    }


    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public String getDepartmentName(){
        return this.getName();
    }
    @Override
    public String getDepartmentDirector(){
        return this.getDirector();
    }




    public String toString(){
        return "Name" + getName() + "Director: " + getDirector() + "Item count: " + getItemCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return itemCount == pharmacy.itemCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCount);
    }
}

