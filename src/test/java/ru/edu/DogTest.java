package ru.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    Dog dog;
    @BeforeEach
    void prepareData(){
        dog = new Dog("Richard", 1);
    }

    @Test
    void testGetDogName() {

        assertEquals("Richard", dog.getName());
    }

    @Test
    void testSetDogName() {

        dog.setName("John");
        assertEquals("Richard", dog.getName());
    }

    @Test
    void testSetDogNameIsEmpty() {
        Dog dogNotName = new Dog("",2);
        dogNotName.setName("John");
        assertEquals("John", dogNotName.getName());
    }

    @Test
    void testGetDogAge() {

        assertEquals(1, dog.getAge());
    }

    @Test
    void testSetDogAge() {

        dog.setAge(2);
        assertEquals(2, dog.getAge());
    }
}