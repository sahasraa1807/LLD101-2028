package models;

import enums.SlotType;

public class ParkingTicket {
    private Vehicle vehicle;
    private int slotId;
    private SlotType slotType;
    private long entryTime;

    public ParkingTicket(Vehicle vehicle, int slotId, SlotType slotType, long entryTime) {
        this.vehicle = vehicle;
        this.slotId = slotId;
        this.slotType = slotType;
        this.entryTime = entryTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public int getSlotId() {
        return slotId;
    }
}