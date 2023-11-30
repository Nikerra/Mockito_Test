package ru.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    private String manufacturer;
    private String number;
    private int year;
    private String owner;
    private List<String> owners = new ArrayList<>();

    public Car(String manufacturer, String number, int year, String owner) {
        this.manufacturer = manufacturer;
        this.number = number;
        this.year = year;
        this.owner = owner;
        owners.add(owner);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
        owners.add(owner);
    }

    public List<String> getOwners() {
        return owners;
    }

    private String testMethod() {
        return "abc";
    }

    private String testMethod(String a){
        return a;
    }

    public int testInt(int a){
        return a+4;
    }

    public void testPrint(Car car) {

        System.out.println(car);
    }

    public void getDataFromRemoteServer() throws Exception {
        throw new Exception("Remote server error");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(manufacturer, car.manufacturer) && Objects.equals(number, car.number) && Objects.equals(owner, car.owner) && Objects.equals(owners, car.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, number, year, owner, owners);
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", owner='" + owner + '\'' +
                ", owners=" + owners +
                '}';
    }
}
