import java.util.ArrayList;
import java.util.List;


/**
 * Garage is a class that stores car. It uses parametric polymorphism.
 *
 * @param <C>
 */
public class garage<C extends Car> implements Containable {
    private int maxStorage;
    private ArrayList<MyObject> storage;

    public garage() {

    }

    /**
     * Constructor: Creates storage for the cars and sets capacity of garage.
     *
     * @param maxStorage
     */
    public garage(int maxStorage) {
        this.maxStorage = maxStorage;
        storage = new ArrayList<MyObject>();
    }

    /**
     * Adds car to the garage as long as there is room.
     *
     * @param car
     */

    public void addCar(C car){
        if (storage.size() < maxStorage) {
            storage.add(car);
        } else {
            throw new IllegalArgumentException("We are full.");
        }
    }

    @Override
    public void addObject(MyObject car) {
        if (storage.size() < maxStorage) {
            storage.add(car);
        } else {
            throw new IllegalArgumentException("We are full.");
        }
    }

    /**
     * Returns the list of the cars in the garage.
     */
    @Override
    public List<MyObject> getStorage() {
        return storage;
    }


    /**
     * Sets maximum capcity of the garage.
     *
     * @param maxStorage
     */
    @Override
    public void setMaxStorage(int maxStorage) {
        this.maxStorage = maxStorage;
    }


    /**
     * Returns the car at the given index
     *
     * @param index
     * @return
     */
    @Override
    public MyObject getObject(int index) {
        return storage.get(index);
    }

    /**
     * Removes the car c from the garage and returns it.
     *
     * @param car
     * @return
     */
    @Override
    public MyObject removeObject(MyObject car) {
        storage.remove(car);
        return car;
    }


    /**
     * Returns the maximum capacity of the garage.
     *
     * @return
     */
    @Override
    public int getMaxStorage() {
        return storage.size();
    }


    public static void main(String[] args) {
        garage<Volvo240> gar = new garage<Volvo240>(10);
        Volvo240 vol = new Volvo240();
        Saab95 sab = new Saab95();

        //gar.addCar(sab);
        //System.out.println(gar.pickUpCar(0).getName());
        gar.addObject(vol);
        gar.addObject(sab);

        System.out.println(gar.removeObject(vol));
        System.out.println(gar.getObject(0));

    }


}
