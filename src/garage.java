import java.util.ArrayList;
import java.util.List;


/**
 * Garage is a class that stores car. It uses parametric polymorphism.
 * @param <C>
 */
public class garage<C extends Car> {

    private int maxStorage;
    public List<C> storage;

    public garage() {

    }

    /**
     * Constructor: Creates storage for the cars and sets capacity of garage.
     * @param maxStorage
     */
    public garage(int maxStorage) {
        this.maxStorage = maxStorage;
        storage = new ArrayList<C>();
    }

    /**
     * Adds car to the garage as long as there is room.
     * @param car
     */
    public void addCar(C car) {
        if(storage.size() < maxStorage){
            storage.add(car);
        } else {
            throw new IllegalArgumentException("We are full.");
        }


    }

    /**
     * Removes the car at the given index from the garage and returns it.
     * @param index
     * @return
     */
    public Car pickUpCar(int index){
            Car car = storage.get(index);
            storage.remove(index);
            return car;
    }

    /**
     * Returns the car at the given index
     * @param index
     * @return
     */
    public Car getCar(int index){
        return storage.get(index);
    }

    public static void main(String[] args){
        garage<Car> gar = new garage<Car>(10);
        Volvo240 vol = new Volvo240();
        Saab95 sab = new Saab95();
        gar.addCar(sab);
        System.out.println(gar.pickUpCar(0).getName());
        gar.addCar(vol);
        System.out.println(gar.pickUpCar(0).getName());

    }




}