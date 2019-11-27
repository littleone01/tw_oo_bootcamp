package parkinglot;

public class ParkingLotResponse {
    public static final String SUCCESS_MSG = "success";
    public static final String FULL_MSG = "failed! parking lot is full.";

    private String message;
    private Car car;

    public ParkingLotResponse(String message) {
        this.message = message;
    }

    public ParkingLotResponse(String message, Car car) {
        this.message = message;
        this.car = car;
    }

    public String getMessage() {
        return message;
    }

    public Car getCar() {
        return car;
    }
}
