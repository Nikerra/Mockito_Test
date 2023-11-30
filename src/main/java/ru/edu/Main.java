package ru.edu;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Car car = new Car("BMW", "X5", 2014, "German government");
        car.testPrint(car);
    }
}