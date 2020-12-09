import java.awt.*;


/**
 * WheelerTruck is a subclass of CarTransport. It can load cars.
 */
public class WheelerTruck extends Truck {
    private boolean rampDown = false;


    public WheelerTruck(){
        super(2, Color.blue, 175, "Wheelertruck", 5, 10);
    }

    /**
     * Constructs the motorvehicle of the truck by calling to Car.java. It also creates the storage for the cars.
     *
     * @param color
     * @param enginePower
     * @param modelName
     * @param weight
     * @param maxStorage
     */
    public WheelerTruck(Color color, double enginePower, String modelName, double weight, int maxStorage) {
        super(2, color, enginePower, modelName, weight, maxStorage);

    }

    /**
     * Starts the engine, given that the ramp is up.
     */
    @Override
    public void startEngine() {
        if (!rampDown) {
            setCurrentSpeed(0.1);
        }

    }

    /**
     * Moves the truck and all the cars that it stores with the distance of the truck's current speed.
     */


    /**
     * Getter for position of ramp.
     *
     * @return
     */
    public boolean getRamp_pos() {
        return rampDown;
    }


    /**
     * Sets down the ramp, given that the truck is not moving.
     */
    public void SetRampDown() {
        if (getCurrentSpeed() == 0) {
            rampDown = true;
        }

    }

    /**
     * Puts up the ramp
     */
    public void SetRampUp() {
        rampDown = false;
    }

    /**
     * Loads the truck with car if the ramp is down, the car is close enough, the is room and the car
     * not too big. The car gets the same x- and y-coordinates as the truck.
     *
     * @param car
     */

    public void loadCars(PhysicalObject car) {
        if (rampDown && measureDist(getX(), car.getX()) <= 1 && measureDist(getY(), car.getY()) <= 1
                && getStorage().size() <= getMaxStorage() && car.getWeight() <= 3) {
            addObject(car);
            car.setX(getX());
            car.setY(getY());
        } else {
            throw new IllegalArgumentException("You have to either lower the ramp, move the car closer to the truck or " +
                    "the car is either too big or there is not enough room.");
        }
    }


    /**
     * Unloads the car that was put in last, given that the ramp is down.. It gets unloaded near the truck.
     */
    public void unloadCar() {
        if (rampDown) {
            PhysicalObject car = getStorage().pop();
            if (getDirection() == NORTH) {
                car.setY(getY() - 1);
            } else if (getDirection() == EAST) {
                car.setX(getX() - 1);
            } else if (getDirection() == SOUTH) {
                car.setY(getY() + 1);
            } else if (getDirection() == WEST) {
                car.setX(getX() + 1);
            }


        }
    }


    public static void main(String[] args) {
        WheelerTruck truck1 = new WheelerTruck(Color.black, 100, "WheelerTruck", 5, 10);
        Volvo240 vol = new Volvo240();
        Saab95 sab = new Saab95();
        truck1.startEngine();
        System.out.println("x:" + truck1.getX() + " " + "y:" + truck1.getY());
        truck1.move();
        truck1.stopEngine();
        System.out.println("x:" + truck1.getX() + " " + "y:" + truck1.getY());
        truck1.SetRampDown();
        truck1.addObject(vol);
        truck1.addObject(sab);
        //truck1.loadCars(truck1);
        truck1.SetRampUp();
        truck1.startEngine();
        truck1.move();
        truck1.turnLeft();
        truck1.move();
        truck1.move();
        //System.out.println(truck1.getCar(0));
        //System.out.println(truck1.getCar(1));
        //System.out.println(truck1.getCar(2));


        System.out.println("x:" + truck1.getX() + " " + "y:" + truck1.getY());
        System.out.println("x:" + sab.getX() + " " + "y:" + sab.getY());
        System.out.println("x:" + vol.getX() + " " + "y:" + vol.getY());

        //System.out.println("x:" + truck1.getX()+ " " + "y:" + truck1.getY());
        //System.out.println("x:" + sab.getX()+ " " + "y:" + sab.getY());
        //System.out.println("x:" + vol.getX()+ " " + "y:" + vol.getY());


    }


}
