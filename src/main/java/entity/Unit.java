package entity;

public enum Unit {
    M(1000),
    DM(100),
    CM(10),
    MM(1);

    private int value;

    Unit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
