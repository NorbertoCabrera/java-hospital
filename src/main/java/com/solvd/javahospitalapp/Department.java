package com.solvd.javahospitalapp;

public abstract class Department {
    protected String name;
    protected String director;


    public Department(String name,String director){
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
