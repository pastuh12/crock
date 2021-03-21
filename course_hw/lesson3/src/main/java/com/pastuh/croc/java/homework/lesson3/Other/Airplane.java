package com.pastuh.croc.java.homework.lesson3.Other;

import com.pastuh.croc.java.homework.lesson3.output.Results;

/**
 * Класс реаизует самолет
 */
public class Airplane extends Avto {

    public Airplane(int id, int cost, String mark) {
        super(id, cost, mark);
        super.setDetails( new Detail[3]);
        super.setDetail(0, new Detail("Бортовой компьютер", 1000000));
        super.setDetail(1, new Detail("Турбина", 1500000));
        super.setDetail(2,new Detail("Шасси", 800000));
        super.setMessanges(new String[2]);
        super.setMessange(0, "Все ОК");
        super.setMessange(1, "Высылаем к вам спсательную бригаду");
    }

    /**
     * Функция обрабатывает ситуацию, когда топливо заканчивается
     * во время аренды
     * @param currentFuel
     */
    public void lowFuelInAir(int currentFuel){
        this.tankUpInAir();
        this.setFuel(currentFuel);
        super.tankUp();
    }

    /**
     * Дозаправка во время аренды
     * Добавляет к итоговой стоимости определенную сумму
     */
    private void tankUpInAir() {
        Results.sendAirTank(this.getId());
        this.setDebt(this.getDebt() + 10000);
    }
}
