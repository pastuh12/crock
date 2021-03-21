package com.pastuh.croc.java.homework.lesson3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class TransportTest {

    Transport tranc = new Transport(2, 200);

    @Test
    public void clientTake() {
        Assertions.assertEquals(3 ,tranc.clientTake(3));
        tranc.setStatus(false);
        Assertions.assertEquals(0 , tranc.clientTake(3));

    }

    @Test
    public void clientLeft() {
        tranc.clientLeft();
        Assertions.assertEquals(true, tranc.getStatus());

    }

    @Test
    public void newDebt() {
        tranc.setTime(5);
        tranc.newDebt();
        Assertions.assertEquals(1000, tranc.getDebt());

    }
}