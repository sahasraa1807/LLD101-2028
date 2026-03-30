package services;

import models.Elevator;
import enums.Direction;
import java.util.*;

public class Scheduler {

    public Elevator findBestElevator(List<Elevator> elevators, int requestFloor) {

        Elevator best = null;
        int bestScore = Integer.MAX_VALUE;

        for (Elevator e : elevators) {

            int distance = Math.abs(e.getCurrentFloor() - requestFloor);

            int load = e.getPendingRequests(); // NEW

            int score = distance + load * 2; // weight load

            if (score < bestScore) {
                bestScore = score;
                best = e;
            }
        }

        return best;
    }
}