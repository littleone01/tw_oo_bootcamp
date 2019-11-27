package parkinglot;

import org.junit.Before;
import org.junit.Test;
import parkinglot.exception.ParkingLotFullException;

import static org.junit.Assert.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1);
    }

    @Test
    public void should_not_take_car_when_not_parking() throws ParkingLotFullException {
//        Car car1 = new Car();
//        Car car2 = new Car();
//        parkingLot.park(car1);
//        assertNull(parkingLot.take(new Token));
    }

    @Test
    public void should_take_car_when_parking() {
//        Car car = new Car();
//        parkingLot.park(car);
//        assertEquals(car, parkingLot.take(car));
//        assertNull(parkingLot.take(car));
    }

    @Test
    public void should_park_when_not_full() {
//        Car car = new Car();
//        ParkingLotResponse parkingLotResponse = parkingLot.park(car);
//        assertEquals("success", parkingLotResponse.getMessage());
//        assertEquals(car, parkingLotResponse.getCar());
    }

    @Test
    public void should_not_park_when_full() {
//        Car car1 = new Car();
//        Car car2 = new Car();
//        ParkingLotResponse parkingLotResponse1 = parkingLot.park(car1);
//        ParkingLotResponse parkingLotResponse2 = parkingLot.park(car2);
//        assertEquals("success", parkingLotResponse1.getMessage());
//        assertEquals("failed! parking lot is full.", parkingLotResponse2.getMessage());
    }
}