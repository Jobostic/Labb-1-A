import java.awt.*;

public class Scania extends Truck {
    private double truckBed_pos;

    public Scania() {
        super(2, Color.black, 150, "Scania", 4, 10);
    }



    /**
     * Constructor: Calls the superclass car to create a vehicle.
     *
     * @param color
     * @param enginePower
     * @param modelName
     * @param weight
     * @param maxStorage
     */
    public Scania(Color color, double enginePower, String modelName, double weight, int maxStorage) {
        super(2, color, enginePower, modelName, weight, maxStorage);
    }

    /**
     * Gets the position of the truckbed in degrees.
     *
     * @return
     */
    public double getTruckBed_pos() {
        return truckBed_pos;
    }


    /**
     * Starts the engine if the truckbed is at most downposition.
     */
    @Override
    public void startEngine() {
        if (truckBed_pos == 0) {
            setCurrentSpeed(0.1);
        } else{
            throw new IllegalArgumentException("The truck bed is not in default position");
        }
    }


    /**
     * Lifts the truckbed by the amount degree as long as the the total degrees is no more than 70.
     *
     * @param degree
     */
    public void LiftTruckBed(double degree) {
        if (degree > 0) {
            if (getCurrentSpeed() == 0 && truckBed_pos + degree <= 70) {
                truckBed_pos += degree;
            } else if (getCurrentSpeed() != 0) {
                throw new IllegalArgumentException("The car is moving.");
            } else {
                throw new IllegalArgumentException("The angle has to be lower than 70 degrees");
            }
        } else {
            throw new IllegalArgumentException("Has to be positive");
        }

    }

    /**
     * Lowers the truckbed with amount degree as long as the total degree does not become negative.
     *
     * @param degree
     */
    public void LowerTruckBed(double degree) {
        if (degree > 0) {
            if (getCurrentSpeed() == 0 && truckBed_pos - degree >= 0) {
                truckBed_pos -= degree;
            } else if (getCurrentSpeed() != 0) {
                throw new IllegalArgumentException("The car is moving.");
            } else {
                throw new IllegalArgumentException("The angle has to be higher than 0 degrees");
            }
        } else {
            throw new IllegalArgumentException("Has to be positive");
        }

    }

}
