package ru.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.edu.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    void testCreateCar() {

        Car car = new Car("BMW", "X5", 2014, "German");
        Car newCar = Mockito.mock(Car.class);

        assertNull(newCar.getManufacturer());
        assertEquals(0, newCar.getYear());
    }

    @Test
    void testRemoteServiceReturnValue() {

        when(car.testInt(4)).thenReturn(10);
        assertEquals(10, car.testInt(4));
    }

    @Test
    void testGetOwnerMockito() {

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
    void testGetManufacturer() {
        assertEquals("BMW", carUnit.getManufacturer());
    }

    @Test
    void testGetNumber() {
        assertEquals("X5", carUnit.getNumber());
    }

    @Test
    void testSetNumber() {
        carUnit.setNumber("X6");
        assertEquals("X6", carUnit.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc-123", "dfg-456", "hjk-789"})
    @NullSource
    @EmptySource
    void testSetParameterizedNumber(String number) {
        carUnit.setNumber(number);
        assertEquals(number, carUnit.getNumber());
    }

    @ParameterizedTest
    @CsvSource({"'abc-123' ,'abc-123' ", " 'dfg-456', 'dfg-456'"})
    void testSetParameterizedNumberTwoValue(String input, String output) {
        carUnit.setNumber(input);
        assertEquals(input, output);
    }

    @ParameterizedTest
    @CsvSource({"'abc-123' ,'alex' ", " 'dfg-456', 'john'"})
    void testSetParameterizedNumberAndOwner(String number, String owner) {
        carUnit.setNumber(number);
        carUnit.setOwner(owner);
        assertEquals(number, carUnit.getNumber());
        assertEquals(owner, carUnit.getOwner());
    }

    @ParameterizedTest
    @CsvSource({"1,5","2,6","3,7"})
    void testIntParameterized(int input, int output) {
        assertEquals(carUnit.testInt(input),output);
    }


    @Test
    void testGetYear() {
        assertEquals(2014, carUnit.getYear());
    }

    @Test
    void testGetOwner() {
        assertEquals("German government", carUnit.getOwner());
    }

    @Test
    void testSetOwner() {
        carUnit.setOwner("Factory BMW");
        assertEquals("Factory BMW", carUnit.getOwner());
    }

    @Test
    void testGetListOwners() {
        List<String> owners = new ArrayList<>(List.of("German government"));
        assertEquals(owners, carUnit.getOwners());
    }
    @Test
    void testGetListTwoOwners() {
        List<String> owners = new ArrayList<>(List.of("German government", "Factory BMW"));
        carUnit.setOwner("Factory BMW");
        assertEquals(owners, carUnit.getOwners());

    }

    @Test
    void testInt() {
        assertEquals(6, carUnit.testInt(2));
    }

    @Test
    void testPrivateMethods(){

        try {
            Method method = Car.class.getDeclaredMethod("testMethod", null);

            method.setAccessible(true);
            assertEquals("abc", method.invoke(carUnit).toString());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPrivateMethodsWithArgument() throws Exception {
        Method method = Car.class.getDeclaredMethod("testMethod", String.class);

        method.setAccessible(true);
        assertEquals( "VW", method.invoke(carUnit, "VW"));
    }

    @Test
    void testPrintConsoleAndVoidMethod(){

        String consoleOutput = null;
        PrintStream originalOut = System.out;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(baos);
            System.setOut(capture);
            carUnit.testPrint(carUnit);
            capture.flush();
            consoleOutput = baos.toString();
            System.setOut(originalOut);
        }catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(carUnit + "\r\n", consoleOutput);
    }

}
