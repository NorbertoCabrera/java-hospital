package com.solvd.javahospitalapp;

import java.util.Objects;

public class Medication {
    private String name;
    private double dosage;

    public Medication(String name, double dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDosage() {
        return dosage;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Double.compare(that.dosage, dosage) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dosage);
    }

    @Override
    public String toString() {
        return "Classes.Medication{" +
                "name='" + name + '\'' +
                ", dosage=" + dosage +
                '}';
    }
}
