package com.pastuh.croc.java.homework.lesson3;

import com.pastuh.croc.java.homework.lesson3.Other.Airplane;
import com.pastuh.croc.java.homework.lesson3.Other.Car;
import com.pastuh.croc.java.homework.lesson3.Other.Ship;
import com.pastuh.croc.java.homework.lesson3.individual.ElectricScooter;
import com.pastuh.croc.java.homework.lesson3.individual.Scooter;
import com.pastuh.croc.java.homework.lesson3.individual.Skateboard;
import com.pastuh.croc.java.homework.lesson3.output.Results;
import org.testng.annotations.Test;

public class Application {
    public static void main(String[] args){
        /**
         * Создаются экземпляры каждого вида транспорта
         */
        Skateboard skate = new Skateboard(2, 5, 400);
        Scooter scooter = new Scooter(3, 10, 500);
        ElectricScooter electro = new ElectricScooter(4, 15, 600);
        Car car = new Car(5, 1500, "Nissan");
        Ship ship = new Ship(6, 2500, "Big_boat");
        Airplane airplane = new Airplane(7, 10000, "Boeing");

        /**
         * Демонстрируются возможности для skate
         */
        skate.clientTake(12);
        Results.takeResult(skate.rentIsOver(30, 7), skate.getId());

        /**
         * Демонстрируются возможности для scooter
         */
        scooter.clientTake(13);
        Results.takeResult(scooter.rentIsOver(40, 5), scooter.getId());
        scooter.repairDone(10);

        /**
         * Демонстрируются возможности для ElectricScooter
         */
        electro.clientTake(14);
        electro.rentIsOver(120, 8, 15);

        /**
         * Демонстрируются возможности для Car
         */
        car.rentIsStart(15, 24);
        car.somethingBroken("Ничег");
        car.somethingBroken("Тормоз");
        car.somethingBroken("Тормоз");
        Results.takeResult(car.rentIsOver(15), car.getId());

        /**
         * Демонстрируются возможности для Airplane
         */
        airplane.rentIsStart(16,40);
        airplane.lowFuelInAir(20);
        airplane.rentIsOver(80);

        /**
         * Демонстрируются возможности для Ship
         */
        ship.rentIsStart(16,40);
        ship.lowFuelInWater(20);
        ship.rentIsOver(80);
    }




}
