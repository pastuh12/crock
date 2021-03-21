package com.pastuh.croc.java.homework.lesson3.Other;

import com.pastuh.croc.java.homework.lesson3.Transport;

/**
 * Класс реализует машину
 */
public class Car extends Avto {

    public Car(int id, int cost, String mark) {
        super(id, cost, mark);
        super.setDetails( new Detail[3]);
        super.setDetail(0, new Detail("Мотор", 10));
        super.setDetail(1, new Detail("Тормоз", 5));
        super.setDetail(2,new Detail("Руль", 3));
        super.setMessanges(new String[4]);
        super.setMessange(0, "Все ОК");
        super.setMessange(1, "Высылаем к вам мастера");
        super.setMessange(2, "Высылаем к вам тягач");
        super.setMessange(3, "Мастер уже в пути");
    }

    /**
     * Преждевременное окончание аренды
     * @param currentTime - новое время аренды
     * @param currentFuel - топливо после аренды
     */
    public void earlyEnd(int currentTime, int currentFuel) {
        super.setTime(currentTime);
        super.newDebt();
        super.rentIsOver(currentFuel);
    }

}
