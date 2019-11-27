package parkinglot;

import org.junit.Test;
import parkinglot.exception.ParkingLotFullException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParkingBoyTest {
    @Test
    public void should_park_to_first_parking_lot_when_first_parking_lot_has_space() throws ParkingLotFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.parkCar(new Car());
        assertEquals(0, parkingLot1.getFreeSpace());
        assertEquals(1, parkingLot2.getFreeSpace());
    }

    @Test
    public void should_park_to_second_parking_lot_when_first_parking_lot_is_full() throws ParkingLotFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.parkCar(new Car());
        parkingBoy.parkCar(new Car());
        assertEquals(0, parkingLot1.getFreeSpace());
        assertEquals(1, parkingLot2.getFreeSpace());
    }

    @Test(expected = ParkingLotFullException.class)
    public void should_throw_parking_lot_full_exception_when_all_parking_lots_are_full() throws ParkingLotFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.parkCar(new Car());
        parkingBoy.parkCar(new Car());
        parkingBoy.parkCar(new Car());
    }


    @Test
    public void should_get_right_car_when_take_the_car_with_right_token() throws ParkingLotFullException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Token token = parkingBoy.parkCar(car1);
        parkingBoy.parkCar(car2);
        Car car = parkingBoy.takeCar(token);
        assertEquals(car1,car);
    }
}