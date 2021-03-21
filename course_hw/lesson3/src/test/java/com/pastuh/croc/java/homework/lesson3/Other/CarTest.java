package com.pastuh.croc.java.homework.lesson3.Other;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class CarTest {

    Car car = new Car(2, 300, "BMW");

    @Before
    public void before(){
        car.setDetails( new Detail[3]);
        car.setDetail(0, new Detail("что то", 100000));
        car.setDetail(1, new Detail("что то2", 150000));
        car.setDetail(2,new Detail("что то3", 130000));
        car.setMessanges(new String[4]);
        car.setMessange(0, "Все ОК");
        car.setMessange(1, "Высылаем к вам мастера");
        car.setMessange(2, "Высылаем к вам тягач");
        car.setMessange(3, "Мастер уже в пути");
    }

    /**
     * Проверка функции earlyEnd
     */
    @Test
    public void earlyEnd() {
        car.earlyEnd(10, 40);
        Assertions.assertEquals(0, car.getTime());
        Assertions.assertEquals(3000, car.getDebt());
    }

}