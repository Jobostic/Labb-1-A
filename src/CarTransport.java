import java.awt.*;

/**
 *  An abstract class for all cars with a loading platform to transport objects
 */
public abstract class CarTransport extends Car{

    private int maxStorage;

    public CarTransport(){
    }


    /**
     * Creates a vehicle for the cartransporter.
     * @param nrDoors
     * @param color
     * @param enginePower
     * @param modelName
     * @param weight
     * @param maxStorage
     */
    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, double weight, int maxStorage){
            super(nrDoors, color, enginePower, modelName, weight);
            this.maxStorage = maxStorage;


    }


    /**
     * Gets the maximum storage capcity.
     * @return
     */
    public int getMaxStorage(){
        return maxStorage;
    }

    /**
     * Sets the maximum storage capacity
     * @param maxStorage
     */
    public void setMaxStorage(int maxStorage){
        this.maxStorage = maxStorage;
    }

    /**
     * Measures the distance between two points in 1D
     * @param x
     * @param y
     * @return
     */
    public static double measureDist(double x, double y){
        return Math.abs(x-y);
    }


}
