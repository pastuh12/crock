package com.pastuh.croc.java.homework.lesson3.Other;

import com.pastuh.croc.java.homework.lesson3.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class AirplaneTest {
    Airplane air = new Airplane(2, 150000, "Boeing");

    @Before
    public void before(){
        air.setDetails( new Detail[3]);
        air.setDetail(0, new Detail("что то", 100000));
        air.setDetail(1, new Detail("что то2", 150000));
        air.setDetail(2,new Detail("что то3", 130000));
        air.setMessanges(new String[2]);
        air.setMessange(0, "Все ОК");
        air.setMessange(1, "Плохо");
    }

    /**
     * Проверка функции lowFuelInWater
     */
    @Test
    public void lowFuelInAir() {
        air.setDebt(500);
        air.setFuel(80);
        air.lowFuelInAir(30);
        Assertions.assertEquals(100, air.getFuel());
        Assertions.assertEquals(10500, air.getDebt());

    }

    /**
     * Проверка функции somethingBroken при одной сломанной детали
     */
    @Test
    public void somethingBroken(){
        air.somethingBroken("что то");
        Assertions.assertEquals(false, air.getStatus());
    }
}