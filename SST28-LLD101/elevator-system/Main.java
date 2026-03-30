import services.ElevatorController;

public class Main {

    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController(2);

        controller.requestElevator(3);
        controller.requestElevator(5);
        controller.requestElevator(9);
        controller.requestElevator(2);

        for (int i = 0; i < 6; i++) {
            controller.step();
        }
    }
}