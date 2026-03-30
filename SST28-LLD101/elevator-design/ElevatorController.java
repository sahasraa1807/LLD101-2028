class ElevatorController {
    private Elevator elevator;

    ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public void requestFloor(int floor) {
        elevator.addRequest(new Request(floor));
    }

    public void step() {
        elevator.move();
    }
}