public class main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        ElevatorController controller = new ElevatorController(elevator);

        elevator.addWeight(1000);  // passengers enter

        controller.requestFloor(5);
        controller.requestFloor(2);

        for (int i = 0; i < 10; i++) {
            controller.step();
        }
    }
}