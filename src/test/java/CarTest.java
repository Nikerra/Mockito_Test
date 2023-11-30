import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ru.edu.Car;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarTest {
    @Mock
    Car car;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
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
}
