package se.lexicon.model;

public enum VehicleType {

    CAR(1),
    MOTORCYCLE(2),
    TRUCK(3),
    VAN(4),
    ELECTRIC(5),
    OTHER(6);

    private final int code;

    VehicleType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

}
