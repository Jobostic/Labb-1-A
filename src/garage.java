import java.util.ArrayList;
import java.util.List;

public class garage<C extends Car> {

    private int maxStorage;
    public List<C> storage;

    public garage() {

    }

    public garage(int maxStorage) {
        this.maxStorage = maxStorage;
        storage = new ArrayList<C>();
    }

    public void addCar(C car) {
        if(storage.size() < maxStorage){
            storage.add(car);
        } else {
            throw new IllegalArgumentException("We are full.");
        }


    }

    public Car getCar (int index){
            Car car = storage.get(index);
            storage.remove(index);
            return car;
    }

    public static void main(String[] args){
        garage<Car> gar = new garage<Car>(10);
        Volvo240 vol = new Volvo240();
        Saab95 sab = new Saab95();
        gar.addCar(sab);
        System.out.println(gar.getCar(0).getName());
        gar.addCar(vol);
        System.out.println(gar.getCar(0).getName());

    }




}