package parkinglot;

import parkinglot.exception.ParkingLotFullException;

import java.util.List;

public class ParkingBoy {
    List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Token parkCar(Car car) throws ParkingLotFullException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getFreeSpace() > 0) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public Car takeCar(Token token) {
        return null;
    }
}
