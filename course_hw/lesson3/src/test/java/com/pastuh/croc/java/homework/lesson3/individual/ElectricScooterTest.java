package com.pastuh.croc.java.homework.lesson3.individual;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class ElectricScooterTest {

    ElectricScooter tranc = new ElectricScooter(2, 400, 1000);

    /**
     * Проверка функции rentIsOver, в случае, когда батарея разряжена после аренды
     */
    @Test
    public void rentIsOver() {
        Assertions.assertEquals(5000 ,tranc.rentIsOver(5, 7, 14 ));
        Assertions.assertEquals(false, tranc.getStatus());
    }
}