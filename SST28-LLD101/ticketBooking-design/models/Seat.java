package models;

import enums.SeatType;

public class Seat {
    private int seatId;
    private SeatType type;
    private boolean isBooked;

    public Seat(int seatId, SeatType type) {
        this.seatId = seatId;
        this.type = type;
        this.isBooked = false;
    }

    public int getSeatId() {
        return seatId;
    }

    public SeatType getType() {
        return type;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        this.isBooked = true;
    }
}