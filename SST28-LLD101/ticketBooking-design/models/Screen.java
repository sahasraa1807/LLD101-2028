package models;

import java.util.List;

public class Screen {
    private int screenId;
    private List<Seat> seats;

    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}