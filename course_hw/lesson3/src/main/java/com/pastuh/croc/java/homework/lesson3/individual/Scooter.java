package com.pastuh.croc.java.homework.lesson3.individual;

/**
 * fuel - показатель топлива
 */
public class Scooter extends Individual {

    private int fuel;

    public Scooter(int id, int cost, int valueOfFine) {
        super(id, cost, valueOfFine);
        this.fuel = 100;
    }
}
