package parkinglot;


import parkinglot.exception.NotFoundCarException;
import parkinglot.exception.ParkingLotFullException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLot {
    private Map<Token, Car> cars;
    private int size;

    public ParkingLot(int size) {
        this.size = size;
        cars = new LinkedHashMap<>();
    }

    public Car take(Token token) throws NotFoundCarException {
        Car takenCar = cars.remove(token);
        if (Objects.isNull(takenCar)) {
            throw new NotFoundCarException();
        }
        return takenCar;
    }

    public Token park(Car car) throws ParkingLotFullException {
        if (size <= cars.size()) {
            throw new ParkingLotFullException();
        }
        Token carToken = new Token();
        cars.put(carToken, car);
        return carToken;
    }

    public int getFreeSpace() {
        return size - cars.size();
    }
}
