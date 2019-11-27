package entity;

public class Length {
    private int value;
    private Unit unit;

    public Length(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public int compare(Length l2) {
        if (getValueInBasicUnit() > l2.getValueInBasicUnit()) {
            return 1;
        } else if (getValueInBasicUnit() < l2.getValueInBasicUnit()) {
            return -1;
        } else {
            return 0;
        }
    }

    private int getValueInBasicUnit() {
        return value * unit.getValue();
    }

    public static Length getBiggerOne(Length l1, Length l2) {
        return l1.compare(l2) >= 0 ? l1 : l2;
    }
}
