/**
 * Class for a logger that prints out the direction of the car
 * after it has turned.
 */

public class CarLogger implements CarObserver {
    @Override
    public void carHasTurned(Car car) {
        if (car.getDirection() == 0) {
            System.out.println("Direction of " + car.getName() + ": NORTH");
        } else if (car.getDirection() == 1) {
            System.out.println("Direction of " + car.getName() + ": EAST");
        } else if (car.getDirection() == 2) {
            System.out.println("Direction of " + car.getName() + ": SOUTH");
        } else if (car.getDirection() == 3) {
            System.out.println("Direction of " + car.getName() + ": WEST");
        }

    }
}
