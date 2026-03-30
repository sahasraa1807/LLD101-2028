package services;

import models.Elevator;
import java.util.*;

public class ElevatorController {

    private List<Elevator> elevators;
    private Scheduler scheduler;

    public ElevatorController(int count) {
        elevators = new ArrayList<>();
        scheduler = new Scheduler();

        for (int i = 0; i < count; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void requestElevator(int floor) {
        Elevator best = scheduler.findBestElevator(elevators, floor);
        best.addRequest(floor);
    }

    public void step() {
        for (Elevator e : elevators) {
            e.move();
        }
    }
}