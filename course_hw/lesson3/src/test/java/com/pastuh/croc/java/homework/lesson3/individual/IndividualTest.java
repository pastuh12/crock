package com.pastuh.croc.java.homework.lesson3.individual;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class IndividualTest {

    Individual tranc = new Individual(2, 300, 500);

    @Test
    public void isThereNewDamage() {
        Assertions.assertEquals(true, tranc.isThereNewDamage(6));

    }

    @Test
    public void timeToRepairs() {
        tranc.setCondition(4);
        Assertions.assertEquals(true, tranc.timeToRepairs());
    }

    @Test
    public void fine() {
        tranc.setCondition(10);
        Assertions.assertEquals(1500, tranc.fine(7));
        tranc.setCondition(6);
        Assertions.assertEquals(0, tranc.fine(7));
    }

    @Test
    public void rentIsOver() {
        Assertions.assertEquals( 4500, tranc.rentIsOver(10, 7));

    }
}