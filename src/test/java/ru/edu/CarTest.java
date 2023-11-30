package ru.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.edu.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarTest {
    @Mock
    Car car;

    Car carUnit;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void createCarData(){
        carUnit = new Car("BMW", "X5", 2014, "German government");
    }
    @Test
    void createCar() {

        Car car = new Car("BMW", "X5", 2014, "German");
        Car newCar = Mockito.mock(Car.class);

        assertNull(newCar.getManufacturer());
        assertEquals(0, newCar.getYear());
    }

    @Test
    void remoteServiceReturnValue() {

        when(car.testInt(4)).thenReturn(10);
        assertEquals(10, car.testInt(4));
    }

    @Test
    void getOwner() {

        when(car.getOwner()).thenReturn("TestOwner");
        assertEquals("TestOwner", car.getOwner());
    }

    @Test
    void verificationTest() {

        car.testInt(4);
        assertNull(car.getOwner());
        verify(car, times(1)).getOwner();
        verify(car).testInt(4);
    }

    @Test
    void getManufacturer() {
        assertEquals("BMW", carUnit.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("X5", carUnit.getNumber());
    }

    @Test
    void setNumber() {
        carUnit.setNumber("X6");
        assertEquals("X6", carUnit.getNumber());
    }

    @Test
    void getYear() {
        assertEquals(2014, carUnit.getYear());
    }

    @Test
    void testGetOwner() {
        assertEquals("German government", carUnit.getOwner());
    }

    @Test
    void setOwner() {
        carUnit.setOwner("Factory BMW");
        assertEquals("Factory BMW", carUnit.getOwner());
    }

    @Test
    void getListOwners() {
        List<String> owners = new ArrayList<>(List.of("German government"));
        assertEquals(owners, carUnit.getOwners());
    }
    @Test
    void getListTwoOwners() {
        List<String> owners = new ArrayList<>(List.of("German government", "Factory BMW"));
        carUnit.setOwner("Factory BMW");
        assertEquals(owners, carUnit.getOwners());

    }

    @Test
    void testInt() {
        assertEquals(6, carUnit.testInt(2));
    }
}
