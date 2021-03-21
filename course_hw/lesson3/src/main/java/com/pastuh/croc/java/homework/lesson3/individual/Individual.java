package com.pastuh.croc.java.homework.lesson3.individual;

import com.pastuh.croc.java.homework.lesson3.Transport;
import com.pastuh.croc.java.homework.lesson3.output.Results;

/**
 * Родительский класс для всего индивидуального транспорта
 * condition - состояние
 * valueOfFine - величина штрафа
 */
public class Individual extends Transport{

    private int condition;
    private int valueOfFine;

    public Individual(int id, int cost, int valueOfFine) {
        super(id, cost);
        condition = 10;
        this.valueOfFine = valueOfFine;
    }

    protected int getCondition() {
        return condition;
    }

    protected void setCondition(int condition) {
        this.condition = condition;
    }

    /**
     * Проверяем, есть ли ухудшения состояния
     * @param newCondition -  новое состояние
     * @return возращаем ответ true - да, есть изменения, false - нет
     */
    public boolean isThereNewDamage(int newCondition){
        if (condition > newCondition){
            return true;
        } else  {
            return false;
        }
    }

    /**
     * Функция проверяет, нужен ли ремонт транспорту
     * @return ответ true - да, false - нет
     */
    public boolean timeToRepairs(){
        if( this.getCondition() <= 5){
            super.setStatus(false);
            Results.sendToRepair(this.getId());
            return true;
        }
        return false;
    }

    /**
     * Функция расчета штрафа
     * @param newCondition - новое состояние транспорта
     * @return штраф за нанесенны1 ущерб
     */
    public int fine(int newCondition) {
        if (isThereNewDamage(newCondition)) {
            return (condition - newCondition) * valueOfFine;
        }
        return 0;
    }

    /**
     * Функция завершения аренды
     * @param rentalTime время, которое транспорт был в аренде
     * @param newCondition новое состояние
     * @return итоговая задолжность
     */
    public int rentIsOver(int rentalTime, int newCondition) {
        setTime(rentalTime);
        super.setDebt(getDebt() + newDebt() + fine(newCondition));
        this.setCondition(newCondition);
        if (true == timeToRepairs()){
            this.repair();
        } else {
            clientLeft();
        }
        return super.getDebt();

    }

    /**
     * Функция выполнения ремонта
     * @param newCondition - новое состояние после ремонта
     */
    public void repairDone(int newCondition){
        condition = newCondition;
        Results.readyToRent(this.getId());
        super.setStatus(true);
    }

}
