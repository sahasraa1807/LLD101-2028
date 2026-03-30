package services;

import enums.VehicleType;
import models.*;
import utils.SlotAllocator;

import java.util.*;

public class ParkingLotService {

    private List<ParkingSlot> slots = new ArrayList<>();
    private Map<Integer, ParkingTicket> activeTickets = new HashMap<>();

    public ParkingLotService(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public ParkingTicket park(Vehicle vehicle, long entryTime) {
        ParkingSlot slot = SlotAllocator.findNearestSlot(slots, vehicle.getType());

        if (slot == null) {
            System.out.println("No slot available");
            return null;
        }

        slot.occupy();

        ParkingTicket ticket = new ParkingTicket(vehicle, slot.getSlotId(), slot.getSlotType(), entryTime);
        activeTickets.put(slot.getSlotId(), ticket);

        return ticket;
    }

    public void status() {
        Map<String, Integer> count = new HashMap<>();

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                count.put(slot.getSlotType().name(),
                        count.getOrDefault(slot.getSlotType().name(), 0) + 1);
            }
        }

        System.out.println("Available slots: " + count);
    }

    public double exit(ParkingTicket ticket, long exitTime) {
        ParkingSlot slot = null;

        for (ParkingSlot s : slots) {
            if (s.getSlotId() == ticket.getSlotId()) {
                slot = s;
                break;
            }
        }

        if (slot != null) {
            slot.free();
        }

        activeTickets.remove(ticket.getSlotId());

        return BillingService.calculateBill(ticket.getSlotType(),
                ticket.getEntryTime(),
                exitTime);
    }
}