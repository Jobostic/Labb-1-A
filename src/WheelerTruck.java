import java.awt.*;
import java.util.LinkedList;

public class WheelerTruck extends Truck {
    private boolean rampDown = false;
    private LinkedList<Car> storeCars;
    private static final int maxStorage = 10;


    public WheelerTruck(Color color, double enginePower, String modelName, double weight) {
        super(2, color, enginePower, modelName, weight);
        storeCars = new LinkedList<Car>();
    }

    @Override
    public void startEngine() {
        if (!rampDown) {
            setCurrentSpeed(0.1);
        }

    }

    @Override
    public void move() {
            if (getDirection() == NORTH) {
                setY(getY() + getCurrentSpeed());
                for (Car c : storeCars) {
                    c.setY(c.getY() + getCurrentSpeed());
                }
            }
         else if (getDirection() == EAST) {
                setX(getX() + getCurrentSpeed());
                for (Car c : storeCars) {
                    c.setX(c.getX() + getCurrentSpeed());
                }
        } else if (getDirection() == SOUTH) {
                setY(getY() - getCurrentSpeed());
                for (Car c : storeCars) {
                    c.setY(c.getY() - getCurrentSpeed());
                }

        } else if (getDirection() == WEST) {
                setX(getX() - getCurrentSpeed());
                for (Car c : storeCars) {
                    c.setX(c.getX() - getCurrentSpeed());
                }
        }
    }



    public boolean getRamp_pos() {
        return rampDown;
    }


    public void SetRampDown() {
        if(getCurrentSpeed() == 0){
            rampDown = true;
        }

    }


    public void SetRampUp() {
        rampDown = false;
    }

    public void loadCars(Car car){
        if(rampDown && Math.abs(getX()-car.getX()) <= 1 && Math.abs(getY()-car.getY()) <= 1
        && storeCars.size() <= maxStorage && car.getWeight() <= 3){
            storeCars.add(car);
            car.setX(getX());     //ändras bilens koordinater med biltransportens koordinater
            car.setY(getY());
        } else{
            throw new IllegalArgumentException("something");
        }
    }

    public void unloadCar(){
        if(rampDown){
            Car car = storeCars.pop();
            car.setX(getX()+1);
            car.setY(getY()+1);
        }
    }

    public void truckBedStorage() {

    }

    public static void main(String[] args){
        WheelerTruck truck1 = new WheelerTruck(Color.black, 100, "WheelerTruck", 5);
        Volvo240 vol = new Volvo240();
        Saab95 sab = new Saab95();
        truck1.startEngine();
        System.out.println("x:" + truck1.getX()+ " " + "y:" + truck1.getY());
        truck1.move();
        truck1.stopEngine();
        System.out.println("x:" + truck1.getX()+ " " + "y:" + truck1.getY());
        truck1.SetRampDown();
        truck1.loadCars(vol);
        truck1.loadCars(sab);
        truck1.SetRampUp();
        truck1.startEngine();
        truck1.move();
        truck1.turnLeft();
        truck1.move();
        truck1.move();


        System.out.println("x:" + truck1.getX()+ " " + "y:" + truck1.getY());
        System.out.println("x:" + sab.getX()+ " " + "y:" + sab.getY());
        System.out.println("x:" + vol.getX()+ " " + "y:" + vol.getY());

        //System.out.println("x:" + truck1.getX()+ " " + "y:" + truck1.getY());
        //System.out.println("x:" + sab.getX()+ " " + "y:" + sab.getY());
        //System.out.println("x:" + vol.getX()+ " " + "y:" + vol.getY());


    }
}
