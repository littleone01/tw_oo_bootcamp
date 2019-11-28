package parkinglot;

import org.junit.Before;
import org.junit.Test;
import parkinglot.exception.NotFoundCarException;
import parkinglot.exception.ParkingLotFullException;

import static org.junit.Assert.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1);
    }

    @Test(expected = NotFoundCarException.class)
    public void should_throw_not_found_car_exception_when_token_not_valid() throws ParkingLotFullException, NotFoundCarException {
        parkingLot.park(new Car());
        parkingLot.take(new Token());
    }

    @Test
    public void should_take_car_when_parking() throws ParkingLotFullException, NotFoundCarException {
        Car car = new Car();
        Token token = parkingLot.park(car);
        assertEquals(car, parkingLot.take(token));
    }

    @Test
    public void should_park_when_not_full() throws ParkingLotFullException {
        Token token = parkingLot.park(new Car());
        assertNotNull(token);
    }

    @Test(expected = ParkingLotFullException.class)
    public void should_throw_parking_lot_full_exception_when_parking_lot_is_full() throws ParkingLotFullException {
        parkingLot.park(new Car());
        parkingLot.park(new Car());
    }

    @Test
    public void should_return_true_when_has_car_token() throws ParkingLotFullException {
        Car car = new Car();
        Token token = parkingLot.park(car);
        assertTrue(parkingLot.hasCar(token));
    }

    @Test
    public void should_return_false_when_not_has_car_token() {
        assertFalse(parkingLot.hasCar(new Token()));
    }

    @Test
    public void should_get_free_space_of_parking_lot() throws ParkingLotFullException {
        assertEquals(1, parkingLot.getFreeSpace());
        parkingLot.park(new Car());
        assertEquals(0, parkingLot.getFreeSpace());
    }
}