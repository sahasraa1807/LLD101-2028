package models;

import enums.Direction;
import java.util.*;

public class Elevator {

    private int id;
    private int currentFloor;
    private Direction direction;

    private TreeSet<Integer> upRequests = new TreeSet<>();
    private TreeSet<Integer> downRequests = new TreeSet<>(Collections.reverseOrder());

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
    }

    public void addRequest(int floor) {
        if (floor > currentFloor) {
            upRequests.add(floor);
        } else {
            downRequests.add(floor);
        }
    }

    public void move() {
        if (direction == Direction.UP || direction == Direction.IDLE) {

            if (!upRequests.isEmpty()) {
                direction = Direction.UP;
                currentFloor = upRequests.pollFirst();

            } else if (!downRequests.isEmpty()) {
                direction = Direction.DOWN;
                currentFloor = downRequests.pollFirst();

            } else {
                direction = Direction.IDLE;
            }

        } else {

            if (!downRequests.isEmpty()) {
                currentFloor = downRequests.pollFirst();

            } else if (!upRequests.isEmpty()) {
                direction = Direction.UP;
                currentFloor = upRequests.pollFirst();

            } else {
                direction = Direction.IDLE;
            }
        }

        System.out.println("Elevator " + id + " at floor " + currentFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }
    public int getPendingRequests() {
    return upRequests.size() + downRequests.size();
}
}