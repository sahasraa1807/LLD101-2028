import enums.*;
import models.*;
import services.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Create Seats
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            seats.add(new Seat(i, SeatType.REGULAR));
        }

        Screen screen = new Screen(1, seats);

        Movie movie = new Movie(1, "Inception");

        Show show = new Show(1, movie, screen, System.currentTimeMillis());

        User user = new User(1, "Sahasra");

        BookingService bookingService = new BookingService();
        PaymentService paymentService = new PaymentService();

        // Select seats
        List<Seat> selectedSeats = seats.subList(0, 3);

        Booking booking = bookingService.createBooking(user, show, selectedSeats);

        if (booking != null) {
            boolean payment = paymentService.makePayment(300);

            if (payment) {
                bookingService.confirmBooking(booking, 300);
                System.out.println("Booking Confirmed!");
            }
        }
    }
}