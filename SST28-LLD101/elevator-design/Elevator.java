import java.util.*;
class Elevator {
    private int currentFloor;
    private Direction direction;
    private Queue<Request> requests;

    private double currentWeight;
    private final double MAX_WEIGHT = 750.0;

    Elevator() {
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.requests = new LinkedList<>();
        this.currentWeight = 0;
    }

       private boolean isOverweight() {
        return currentWeight > MAX_WEIGHT;
    }

    // Add request only if weight is safe
    public void addRequest(Request request) {
        if (isOverweight()) {
            System.out.println("Cannot move. Elevator overloaded!");
            return;
        }
        requests.offer(request);
    }

    public void addWeight(double weight) {
        currentWeight += weight;
    }

    public void removeWeight(double weight) {
        currentWeight -= weight;
    }

 

    public void move() {
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        Request targetReq = requests.peek();
        int targetFloor = targetReq.floor;

        if (currentFloor < targetFloor) {
            direction = Direction.UP;
            currentFloor++;
        } else if (currentFloor > targetFloor) {
            direction = Direction.DOWN;
            currentFloor--;
        } else {
            // reached destination
            requests.poll();
            openDoor();
        }
    }

    private void openDoor() {
        System.out.println("Door opened at floor " + currentFloor);
    }

    // getters (important for controller)
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
}