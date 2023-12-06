package com.solvd.javahospitalapp;

//import Interfaces.IDepartmentInformation;

import com.solvd.javahospitalapp.Interfaces.IDepartmentInformation;

import java.util.List;
import java.util.Objects;

public class HospitalWard extends Department implements IDepartmentInformation {

    private List<HospitalRoom> rooms;
    private List<Patient> patients;


    public HospitalWard(String name,String director) {
        super(name,director);

    }





    public List<HospitalRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<HospitalRoom> rooms) {
        this.rooms = rooms;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
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
        return "Name" + getName() + "Director: " + getDirector() + "Rooms:" + getRooms() + "Patients: "+ getPatients();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalWard that = (HospitalWard) o;
        return Objects.equals(rooms, that.rooms) && Objects.equals(patients, that.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, patients);
    }
}
