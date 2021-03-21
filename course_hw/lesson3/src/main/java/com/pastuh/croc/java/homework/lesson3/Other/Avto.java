package com.pastuh.croc.java.homework.lesson3.Other;

import com.pastuh.croc.java.homework.lesson3.Transport;
import com.pastuh.croc.java.homework.lesson3.output.Results;

/**
 * Родительский класс для транспорта с двигателем
 * mark - марка транспорта
 * fuel - показатель топлива
 * details - массив важных деталий транспорта
 * messages - массив сообщений для пользователей о транспорте
 */
public class Avto extends Transport {
    private String mark;
    private int fuel;
    private Detail[] details;
    private String messanges[];

    public Avto(int id, int cost, String mark) {
        super(id, cost);
        this.mark = mark;
        this.fuel = 100;
    }

    public String[] getMessanges() {
        return messanges;
    }

    public String getMessange(int i) {
        return messanges[i];
    }

    public void setMessanges(String[] messange) {
        this.messanges = messange;
    }

    public void setMessange(int i, String messange) {
        this.messanges[i] = messange;
    }

    public Detail[] getDetails() {
        return details;
    }

    public Detail getDetail(int i) {
        return details[i];
    }

    public void setDetails(Detail[] details) {
        this.details = details;
    }

    public void setDetail(int i, Detail newDetail) {
        this.details[i] = newDetail;
    }

    /**
     * Функция начала аренды
     * @param clientId - id клинта, взявшего транспорт в аренду
     * @param time - фиксированное время аренды
     */
    public void rentIsStart(int clientId, int time){
        if ( 0 == super.clientTake(clientId)) {
            System.out.println("Транспорт сейчас недоступен");
        } else {
            super.setTime(time);
            super.setDebt(super.newDebt());
        }
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    /**
     * Функция завершения аренды
     * @param newFuel - топливо после аренды
     * @return
     */
    public int rentIsOver(int newFuel ){
        int fine = 0;
        super.clientLeft();
        fine = costForRepairs();
        super.setDebt(super.getDebt() + fine);
        setFuel(newFuel);
        this.lowFuel();
        return super.getDebt();
    }

    /**
     * Отправка транспорта на ремонт
     * @param detail - индекс детали, которая сломалась
     */
    protected void sendForRepair(int detail){
        Results.somethingBroken(details[detail].getName(), this.getId());
        super.repair();
    }

    /**
     * Стоимость ремонта, возлагаемая на клиента
     * @return итоговая стоимость ремонта
     */
    protected int costForRepairs(){
        int sum = 0;
        for (int i = 0; i < details.length; i++) {
            if(details[i].getStatus() == false){
                sum = details[i].getRepairCost();
                sendForRepair(i);
            }
        }
        return sum;
    }

    /**
     * Функия проверят, сломалась ли определенная деталь или нет, и
     * случилось ли это во время активированной аренды
     * Если это так, то будет выведено экстренное сообщение
     * @param nameDetail - выводит название детали, котороя сломалась
     */
    public void somethingBroken(String nameDetail){
        boolean f = false;
        for (int i = 0; i < details.length; i++) {
            if(details[i].getName().equals(nameDetail)){
                details[i].setStatus(false);
                if (this.getStatus() == false && this.getClientId() != -1){
                    f = true;
                    Results.statusMessange(messanges[i + 1]);
                    break;
                }
                else {
                    f = true;
                    this.sendForRepair(i);
                    break;
                }
            }
        }
        if(f == false){
            Results.statusMessange(messanges[0]);
        }
    }

    /**
     * Функция проверяет заканчивается топливо или нет
     */
    public void lowFuel() {
        if (fuel <= 15) {
            Results.fuelLow(this.fuel);
            setStatus(false);
        }
    }

    /**
     * Заправка транспорта
     */
    public void tankUp(){
        this.setFuel(100);
        Results.tankRefiiled(this.getId());
    }
}
