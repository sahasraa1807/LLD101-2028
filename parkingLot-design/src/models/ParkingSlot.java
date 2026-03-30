package models;

import enums.SlotType;

public class ParkingSlot {
    private int slotId;
    private SlotType slotType;
    private boolean isOccupied;
    private int distanceFromGate;

    public ParkingSlot(int slotId, SlotType slotType, int distanceFromGate) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.distanceFromGate = distanceFromGate;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        this.isOccupied = true;
    }

    public void free() {
        this.isOccupied = false;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public int getDistanceFromGate() {
        return distanceFromGate;
    }

    public int getSlotId() {
        return slotId;
    }
}