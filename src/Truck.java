import java.awt.*;
import java.util.LinkedList;

/**
 * An abstract class for all cars with a loading platform to transport objects
 */
public abstract class Truck extends Car implements Containable {
    private LinkedList<PhysicalObject> storage;
    private int maxStorage;

    public Truck() {
        storage = new LinkedList<PhysicalObject>();
    }


    /**
     * Creates a vehicle for the truck.
     *
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
     * @param weight
     * @param maxStorage
     */
    public Truck(int nrDoors, Color color, double enginePower, String modelName, double weight, int maxStorage) {
        super(nrDoors, color, enginePower, modelName, weight);
        this.maxStorage = maxStorage;
        storage = new LinkedList<PhysicalObject>();

    }

    /**
     * Returns the list of the storage
     *
     * @return
     */
    public LinkedList<PhysicalObject> getStorage() {
        return storage;
    }


    /**
     * Gets the maximum storage capcity.
     *
     * @return
     */
    public int getMaxStorage() {
        return maxStorage;
    }

    /**
     * Sets the maximum storage capacity
     *
     * @param maxStorage
     */
    public void setMaxStorage(int maxStorage) {
        this.maxStorage = maxStorage;
    }

    /**
     * Measures the distance between two points in 1D
     *
     * @param x
     * @param y
     * @return
     */
    public static double measureDist(double x, double y) {
        return Math.abs(x - y);
    }


    /**
     * Overrides the move method in car. It moves the truck and the objects that it is storing.
     */
    @Override
    public void move() {
        super.move();
        if (!storage.isEmpty()) {
            for (PhysicalObject c : storage) {
                c.setX(super.getX());
                c.setY(super.getY());
            }
        }

    }


    /**
     * Adds object to the storage.
     *
     * @param c
     */
    public void addObject(PhysicalObject c) {
        storage.add(c);
    }


    /**
     * Returns the object at index i
     *
     * @param i
     * @return
     */
    public PhysicalObject getObject(int i) {
        return storage.get(i);
    }

    /**
     * Removes the object c from storage.
     *
     * @param c
     */
    public PhysicalObject removeObject(PhysicalObject c) {
        PhysicalObject object = c;
        storage.remove(c);
        return c;
    }
}
