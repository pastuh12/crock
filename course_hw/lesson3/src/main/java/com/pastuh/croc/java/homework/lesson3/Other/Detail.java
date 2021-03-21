package com.pastuh.croc.java.homework.lesson3.Other;

/**
 * Класс реализует детали
 * name - название детали
 * repairCost - стоимость ремонта
 * status - сломана она или нет(true - не сломана)
 */
public class Detail {
    private String name;
    private int repairCost;
    private boolean status;

    public int getRepairCost() {
        return repairCost;
    }

    public boolean isStatus() {
        return status;
    }

    public Detail(String name, int repairCost) {
        this.name = name;
        this.repairCost = repairCost;
        this.status = true;
    }

    public String getName() {
        return name;
    }


    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
