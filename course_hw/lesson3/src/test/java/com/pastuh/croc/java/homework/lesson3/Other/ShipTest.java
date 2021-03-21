package com.pastuh.croc.java.homework.lesson3.Other;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class ShipTest {

    Ship ship = new Ship(2, 300, "Big");

    @Before
    public void before(){
        ship.setDetails( new Detail[3]);
        ship.setDetail(0, new Detail("что то", 100000));
        ship.setDetail(1, new Detail("что то2", 150000));
        ship.setDetail(2,new Detail("что то3", 130000));
    }

    /**
     * Проверка функции lowFuelInWater
     */
    @Test
    public void lowFuelInWater() {
        ship.rentIsStart(2, 1);
        ship.setDebt(500);
        ship.setFuel(80);
        ship.lowFuelInWater(30);
        Assertions.assertEquals(100, ship.getFuel());
        Assertions.assertEquals(10500, ship.getDebt());
    }
}