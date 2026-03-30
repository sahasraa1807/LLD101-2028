import enums.VehicleType;
import java.util.*;
import models.*;
import services.ParkingLotService;

public class Main {
    public static void main(String[] args) {

        List<ParkingSlot> slots = Arrays.asList(
                new ParkingSlot(1, enums.SlotType.SMALL, 10),
                new ParkingSlot(2, enums.SlotType.MEDIUM, 5),
                new ParkingSlot(3, enums.SlotType.LARGE, 2)
        );

        ParkingLotService service = new ParkingLotService(slots);

        Vehicle car = new Vehicle("KA01AB1234", VehicleType.CAR);

        ParkingTicket ticket = service.park(car, System.currentTimeMillis());

        service.status();

        double bill = service.exit(ticket, System.currentTimeMillis() + 2 * 60 * 60 * 1000);

        System.out.println("Bill: " + bill);
    }
}