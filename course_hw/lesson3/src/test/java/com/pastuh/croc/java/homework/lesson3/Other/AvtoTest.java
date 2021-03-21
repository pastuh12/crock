package com.pastuh.croc.java.homework.lesson3.Other;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.*;

/**
 * Тесты для класса Avto
 */
public class AvtoTest {
    Avto avto = new Avto(2, 300, "какой то транспорт");

    /**
     * Действия, выполняющиеся перед каждым тестом
     */
    @Before
    public void before(){
        avto.setDetails( new Detail[3]);
        avto.setDetail(0, new Detail("что то", 100));
        avto.setDetail(1, new Detail("что то2", 100));
        avto.setDetail(2,new Detail("что то3", 100));
        avto.setMessanges(new String[4]);
        avto.setMessange(0, "Все ОК");
        avto.setMessange(1, "Высылаем к вам мастера");
        avto.setMessange(2, "Высылаем к вам тягач");
        avto.setMessange(3, "Мастер уже в пути");
    }

    /**
     * Проверка функции rentIsStart
     */
    @Test
    public void rentIsStart() {
        avto.rentIsStart(3, 2);
        Assertions.assertEquals(3, avto.getClientId());
        Assertions.assertEquals(2, avto.getTime());
        Assertions.assertEquals(600, avto.getDebt());

    }

    /**
     * Проверка функции costForRepairs, когда одна делать сломана
     */
    @Test
    public void costForRepairsWithFalse() {
        avto.getDetail(0).setStatus(false);
        Assertions.assertEquals(100, avto.costForRepairs());

    }

    /**
     * Проверка функции costForRepairs, когда ни одна делать не сломана
     */
    @Test
    public void costForRepairsWithOutFalse() {
        Assertions.assertEquals(0, avto.costForRepairs());

    }

    /**
     * Проверка функции rentIsOver, когда один элемент поврежден
     */
    @Test
    public void rentIsOverWithFalse() {
        Assertions.assertEquals(0, avto.getDebt());

        avto.getDetail(0).setStatus(false);
        avto.rentIsOver(50);
        Assertions.assertEquals(false ,avto.getStatus());
        Assertions.assertEquals( 100 ,avto.getDebt());
        Assertions.assertEquals( 50 ,avto.getFuel());
    }

    /**
     * Проверка функции rentIsOver, когда один элемент поврежден
     */
    @Test
    public void rentIsOverWithOutFalse() {
        Assertions.assertEquals(0, avto.getDebt());
        avto.rentIsOver(50);
        Assertions.assertEquals(true ,avto.getStatus());
        Assertions.assertEquals( 0 ,avto.getDebt());
        Assertions.assertEquals( 50 ,avto.getFuel());
    }

    /**
     * Проверка функции sendForRepair
     */
    @Test
    public void sendForRepair() {
        Assertions.assertEquals(0, avto.getDebt());
        avto.getDetail(1).setStatus(false);
        avto.sendForRepair(0);
        Assertions.assertEquals(false, avto.getStatus());

    }

    /**
     * Проверка функции somethingBroken, когда транспорт уже арендован
     */
    @Test
    public void somethingBrokenInRent() {
        avto.setStatus(false);
        avto.somethingBroken("что то");
        Assertions.assertEquals(false, avto.getDetail(0).getStatus());
    }

    /**
     * Проверка функции lowFuel, когда топливо <= 15
     */
    @Test
    public void lowFuelLess15() {
        avto.lowFuel();
        Assertions.assertEquals(true, avto.getStatus());
        avto.setFuel(15);
        avto.lowFuel();
        Assertions.assertEquals(false, avto.getStatus());
    }

    /**
     * Проверка функции lowFuel, когда топливо > 15
     */
    @Test
    public void lowFuelMore15() {
        avto.lowFuel();
        Assertions.assertEquals(true, avto.getStatus());
        avto.setFuel(20);
        avto.lowFuel();
        Assertions.assertEquals(true, avto.getStatus());
    }

    /**
     * Проверка функции tankUp
     */
    @Test
    public void tankUp() {
        avto.setFuel(20);
        avto.tankUp();
        Assertions.assertEquals(100, avto.getFuel());
    }
}