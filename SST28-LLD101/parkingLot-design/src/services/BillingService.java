package services;

import enums.SlotType;

import java.util.HashMap;
import java.util.Map;

public class BillingService {

    private static final Map<SlotType, Integer> rates = new HashMap<>();

    static {
        rates.put(SlotType.SMALL, 10);
        rates.put(SlotType.MEDIUM, 20);
        rates.put(SlotType.LARGE, 30);
    }

    public static double calculateBill(SlotType type, long entryTime, long exitTime) {
        long duration = (exitTime - entryTime) / (1000 * 60 * 60); // hours
        duration = Math.max(duration, 1);

        return duration * rates.get(type);
    }
}