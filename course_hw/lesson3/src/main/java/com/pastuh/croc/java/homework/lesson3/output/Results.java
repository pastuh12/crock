package com.pastuh.croc.java.homework.lesson3.output;

import com.pastuh.croc.java.homework.lesson3.Other.Detail;

public class Results {

    public static void takeResult(int result, int transportId ){
        System.out.println("Итоговая стоимость аренды транспорта №" + transportId + ":" + result + "\n");
    }

    public static void sendToRepair(int transportId) {
        System.out.println("Транспорт №" + transportId + " сильно поврежден, нужен ремонт");
    }

    public static void readyToRent(int transportId) {
        System.out.println("Транспорт №"+ transportId + " отремонтирован и готов к аренде\n");
    }

    public static void statusMessange(String massange) {
        System.out.println(massange);
    }

    public static void batteryLow(int transportId) {
        System.out.println("Необходимо откатить самокат №" + transportId + " на подзарядку\n");
    }

    public static void batteryCharg(int transportId) {
        System.out.println("Самокат №" + transportId + " заряжен и может быть сдан в аренду \n");

    }

    public static void somethingBroken(String nameDetail, int transportId) {
        System.out.println("Сломалась важная система - " + nameDetail +
                ". Какое то время транспорт №" + transportId + " будет недоступен");
    }

    public static void fuelLow(int transportId) {
        System.out.println("Необходимо заправить транспорт №" + transportId);
    }

    public static void tankRefiiled(int transportId) {
        System.out.println("Транспорт №" + transportId + " заправлен \n");
    }

    public static void sendAirTank(int transportId) {
        System.out.println("Выслали к самолету №" + transportId + " самолет-дозаправщик");
    }

    public static void sendWaterTank(int transportId) {
        System.out.println("Выслали к кораблю №" + transportId + " корабль-дозаправщик");
    }

    public static void trancNotAvailable(int transportId) {
        System.out.println("Транспорт №" + transportId + " в данный момент недоступен");
    }
}
