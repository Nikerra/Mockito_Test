package ru.edu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    Dog dog = new Dog("Richard", 1);
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
        Dog dog = new Dog("",2);
        dog.setName("John");
        assertEquals("John", dog.getName());
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