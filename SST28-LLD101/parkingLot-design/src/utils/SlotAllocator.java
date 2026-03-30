package utils;

import enums.SlotType;
import enums.VehicleType;
import models.ParkingSlot;

import java.util.List;

public class SlotAllocator {

    public static ParkingSlot findNearestSlot(List<ParkingSlot> slots, VehicleType vehicleType) {
        ParkingSlot bestSlot = null;

        for (ParkingSlot slot : slots) {
            if (slot.isOccupied()) continue;

            if (isCompatible(vehicleType, slot.getSlotType())) {
                if (bestSlot == null || slot.getDistanceFromGate() < bestSlot.getDistanceFromGate()) {
                    bestSlot = slot;
                }
            }
        }

        return bestSlot;
    }

    private static boolean isCompatible(VehicleType vType, SlotType sType) {
        switch (vType) {
            case BIKE:
                return true;
            case CAR:
                return sType == SlotType.MEDIUM || sType == SlotType.LARGE;
            case BUS:
                return sType == SlotType.LARGE;
        }
        return false;
    }
}