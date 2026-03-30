package services;

import models.Seat;

import java.util.HashSet;
import java.util.Set;

public class SeatLockService {

    private Set<Integer> lockedSeats = new HashSet<>();

    public boolean lockSeats(Set<Seat> seats) {
        for (Seat seat : seats) {
            if (lockedSeats.contains(seat.getSeatId()) || seat.isBooked()) {
                return false;
            }
        }

        for (Seat seat : seats) {
            lockedSeats.add(seat.getSeatId());
        }
        return true;
    }

    public void unlockSeats(Set<Seat> seats) {
        for (Seat seat : seats) {
            lockedSeats.remove(seat.getSeatId());
        }
    }
}