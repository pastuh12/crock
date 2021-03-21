package com.pastuh.croc.java.homework.lesson3.individual;

import com.pastuh.croc.java.homework.lesson3.output.Results;

/**
 * battery - заряд батареи
 */
public class ElectricScooter extends Individual {

    int battery;

    protected void setBattery(int battery) {
        this.battery = battery;
    }

    public ElectricScooter(int id, int cost, int valueOfFine) {
        super(id, cost, valueOfFine);
        this.battery = 100;
    }

    public int getBattery() {
        return battery;
    }

    /**
     * Функция проверяет разряжается самокат или нет
     */
    public void lowBattery() {
        if (battery <= 15) {
            Results.batteryLow(this.getId());
            setStatus(false);
        }
    }

    /**
     * Функция перезарядки самоката
     */
    public void batteryCharged(){
        this.setBattery(100);
        Results.batteryCharg(this.getId());
    }

    /**
     * Функция завершение аренды с модификацией для ElectroScooter
     * @param rentalTime время аренды
     * @param newCondition состояние после аренды
     * @param newBattery батарея после аренды
     * @return
     */
    public int rentIsOver(int rentalTime, int newCondition, int newBattery) {
        setBattery(newBattery);
        int currentDebt = super.rentIsOver(rentalTime, newCondition);
        lowBattery();
        return currentDebt;
    }


}
