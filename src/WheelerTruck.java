import java.awt.*;
import java.util.LinkedList;

public class WheelerTruck extends Truck {
    private boolean rampDown = false;
    LinkedList<Car> storeCars;
    private static final int maxStorage = 10;


    public WheelerTruck(Color color, double enginePower, String modelName, double weight){
        super(2, color, enginePower, modelName, weight);
        storeCars = new LinkedList<Car>();
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
        if(rampDown && (getX()-car.getX()) <= 10 && (getY()-car.getY()) <= 10
        && storeCars.size() <= maxStorage && car.getWeight() <= 3){
            storeCars.add(car);
            car.setX(getX());     //ändras bilens koordinater med biltransportens koordinater
            car.setY(getY());
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
}
