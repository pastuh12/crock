package com.pastuh.croc.java.homework.lesson3.Other;

import com.pastuh.croc.java.homework.lesson3.output.Results;

/**
 * Класс релизует корабль
 */
public class Ship extends Avto {


    public Ship(int id, int cost, String mark) {
        super(id, cost, mark);
        super.setDetails( new Detail[3]);
        super.setDetail(0, new Detail("Мотор", 100000));
        super.setDetail(1, new Detail("Штурвал", 150000));
        super.setDetail(2,new Detail("Днище", 130000));
        super.setMessanges(new String[4]);
        super.setMessange(0, "Все ОК");
        super.setMessange(1, "Подождите, скоро приедет помощь");
        super.setMessange(2, "Высылаем к вам морскую службу спасения");
        super.setMessange(3, "Включите насос и дождитесь спасателей");
    }

    /**
     * Функция обрабатывает ситуацию, когда топливо заканчивается
     * во время аренды
     * @param currentFuel
     */
    public void lowFuelInWater(int currentFuel){
        if (this.getStatus() == false && this.getClientId() != -1) {
            this.tankUpInWater();
            this.setFuel(currentFuel);
            super.tankUp();
        }
    }

    /**
     * Дозаправка во время аренды
     * Добавляет к итоговой стоимости определенную сумму
     */
    private void tankUpInWater() {
        Results.sendWaterTank(this.getId());
        this.setDebt(this.getDebt() + 10000);
    }
}
