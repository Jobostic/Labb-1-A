import java.util.ArrayList;
import java.util.LinkedList;

public class garage {


    private int maxStorage;
    private ArrayList<Car> storage;
    private Car carType;

    public garage(int maxStorage) {
        this.maxStorage = maxStorage;
        carType = null;
    }

    public garage(int maxStorage, Car carType){
        this.maxStorage = maxStorage;
        this.carType = carType;
    }

    public void receiveCar(Car car){
        if(carType == null){
            storage.add(car);
        } else if(carType.getName().equals(car.getName())){
            storage.add(car);
        }
    }

    public void getCar(Car car){

    }

}