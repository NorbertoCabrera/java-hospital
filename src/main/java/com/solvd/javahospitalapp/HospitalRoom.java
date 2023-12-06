package com.solvd.javahospitalapp;

public final class HospitalRoom {
    private static int number;
    private boolean occupied;
    private static int ROOMS_CREATED = 0;


    public HospitalRoom(int number, boolean occupied) {
        this.number = number;
        this.occupied = occupied;
        ROOMS_CREATED++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }


    public static int getRoomsCreated (){
        return ROOMS_CREATED;
    }

    public String toString(){
        return "Room number: " + getNumber() + "Is occupied?: " + isOccupied();
    }
}
