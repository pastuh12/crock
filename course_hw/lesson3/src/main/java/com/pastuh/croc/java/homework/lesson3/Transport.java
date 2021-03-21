package com.pastuh.croc.java.homework.lesson3;

import com.pastuh.croc.java.homework.lesson3.output.Results;

/**
 * Родительский класс для всех классов
 * id - id транспорта
 * status - состояние
 * clientId - id клиента, который арендовал транспорт
 * cost - стоимость
 * time -  время аренды
 * debt - долг за аренду
 */
public class Transport {
    private int id;
    private boolean status;
    private int clientId;
    private int cost;
    private int time;
    private int debt;

    public Transport(int id, int cost) {
        this.id = id;
        this.status = true;
        this.clientId = -1;
        this.cost = cost;
        this.time = 0;
        this.debt = 0;
    }

    public int getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getClientId() {
        return clientId;
    }

    public int getCost() {
        return cost;
    }

    public int getTime() {
        return time;
    }

    public int getDebt() {
        return debt;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }


    /**
     * Функция приязки клиента и транспорта
     * @param clientId - получаем id клиента
     * @return выводим clientId для того, чтобы потом вывести его в отчете
     */
    protected int clientTake(int clientId){
        if (status == true) {
            this.clientId = clientId;
            status = false;
            time = 0;
            return clientId;
        } else {
            if(status == false){
                Results.trancNotAvailable(id);
            }
        }
        return 0;
    }

    /**
     * Отвязка клиента от транспорта
     */
    protected void clientLeft(){
        this.clientId = -1;
        status = true;
        time = 0;
    }

    /**
     * Ремонт транспорта
     */
    protected void repair(){
        time = 0;
        status = false;
    }

    /**
     * Пересчитывание долга
     * @return возвращаем новый долг
     */
    protected int newDebt(){
        debt = this.cost * this.time;
        return debt;
    }

}
