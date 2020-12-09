import java.util.ArrayList;
import java.util.List;


/**
 * Garage is a class that stores car. It uses parametric polymorphism.
 *
 * @param <C>
 */
public class garage<C extends Car> {
    private int maxStorage;
    private ArrayList<C> storage;
    private CarFactory carFactory = new CarFactory();
    private static int DIST_BETWEEN_PICS = 100;
    private static int nbrOfCars = 0;
    private int k = 0;


    public garage() {
        storage = new ArrayList<C>();
    }

    /**
     * Constructor: Creates storage for the cars and sets capacity of garage.
     *
     * @param maxStorage
     */
    public garage(int maxStorage) {
        this.maxStorage = maxStorage;
        storage = new ArrayList<C>();
    }

    /**
     * Adds car to the garage as long as there is room.
     *
     * @param car
     */


    public void addCar(C car){
        if (storage.size() < maxStorage) {
            storage.add(car);

            if (car.getY() + nbrOfCars * DIST_BETWEEN_PICS < 500 && k == 0) {
                car.setY(car.getY() + nbrOfCars * DIST_BETWEEN_PICS);
                car.setX(0);
                nbrOfCars++;
            } else {
                car.setY(car.getY() + k * DIST_BETWEEN_PICS);
                car.setX(DIST_BETWEEN_PICS);
                k++;
            }
        } else {
            throw new IllegalArgumentException("We are full.");
        }
    }

    public ArrayList<C> getStorage(){
        return storage;
    }

    public void removeCar(C car){
        storage.remove(car);
    }

    public void removeCar(String s){
        ArrayList<Car> toRemove = new ArrayList<Car>();
        for (Car car : storage) {
            if (car.getName().equals(s)) {
                toRemove.add(car);
                nbrOfCars--;
            }
        }
        storage.remove(toRemove.get(0));

    }

//    @Override
//    public void addObject(PhysicalObject car) {
//        if (storage.size() < maxStorage) {
//            storage.add(car);
//        } else {
//            throw new IllegalArgumentException("We are full.");
//        }
//    }
//
//    /**
//     * Returns the list of the cars in the garage.
//     */
//    @Override
//    public List<PhysicalObject> getStorage() {
//        return storage;
//    }
//
//
//    /**
//     * Sets maximum capcity of the garage.
//     *
//     * @param maxStorage
//     */
//    @Override
//    public void setMaxStorage(int maxStorage) {
//        this.maxStorage = maxStorage;
//    }
//
//
//    /**
//     * Returns the car at the given index
//     *
//     * @param index
//     * @return
//     */
//    @Override
//    public PhysicalObject getObject(int index) {
//        return storage.get(index);
//    }
//
//    /**
//     * Removes the car c from the garage and returns it.
//     *
//     * @param car
//     * @return
//     */
//    @Override
//    public PhysicalObject removeObject(PhysicalObject car) {
//        storage.remove(car);
//        return car;
//    }
//
//
//    /**
//     * Returns the maximum capacity of the garage.
//     *
//     * @return
//     */
//    @Override
//    public int getMaxStorage() {
//        return storage.size();
//    }
//
//
//    public static void main(String[] args) {
//        garage<Volvo240> gar = new garage<Volvo240>(10);
//        Volvo240 vol = new Volvo240();
//        Saab95 sab = new Saab95();
//
//        //gar.addCar(sab);
//        //System.out.println(gar.pickUpCar(0).getName());
//        gar.addObject(vol);
//        gar.addObject(sab);
//
//        System.out.println(gar.removeObject(vol));
//        System.out.println(gar.getObject(0));
//
//    }


}
