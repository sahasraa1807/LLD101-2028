package services;

import models.*;
import java.util.*;

public class BookingService {

    private Map<Integer, Booking> bookings = new HashMap<>();
    private SeatLockService seatLockService = new SeatLockService();
    private int bookingCounter = 1;

    public Booking createBooking(User user, Show show, List<Seat> seats) {
        Set<Seat> seatSet = new HashSet<>(seats);

        if (!seatLockService.lockSeats(seatSet)) {
            System.out.println("Seats not available");
            return null;
        }

        Booking booking = new Booking(bookingCounter++, user, show, seats);
        bookings.put(booking.getBookingId(), booking);

        return booking;
    }

    public void confirmBooking(Booking booking, double amount) {
        for (Seat seat : booking.getSeats()) {
            seat.book();
        }

        booking.confirm(amount);
    }
}