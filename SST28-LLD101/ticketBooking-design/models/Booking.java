package models;

import enums.BookingStatus;

import java.util.List;

public class Booking {
    private int bookingId;
    private User user;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;
    private double amount;

    public Booking(int bookingId, User user, Show show, List<Seat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.PENDING;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void confirm(double amount) {
        this.status = BookingStatus.CONFIRMED;
        this.amount = amount;
    }

    public int getBookingId() {
        return bookingId;
    }
}