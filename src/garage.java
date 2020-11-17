import java.util.ArrayList;
import java.util.List;

public class garage {


    private int maxStorage;
    private List<Car> storage;    // Komposition, garaget "har" bilar
    private String garageBrand;

    public garage(int maxStorage) {
        this.maxStorage = maxStorage;
        storage = new ArrayList<Car>();
        garageBrand = "";
    }

    public garage(int maxStorage, String garageBrand){
        this.maxStorage = maxStorage;
        this.garageBrand = garageBrand;
        storage = new ArrayList<Car>();
    }

    public void receiveCar(Car car){
        if(garageBrand == ""){
            storage.add(car);
        } else if(garageBrand.equals(car.getName())){
            storage.add(car);
        }
    }

    public Car getCar(Car car){//first in first out?
        return car;
    }

}