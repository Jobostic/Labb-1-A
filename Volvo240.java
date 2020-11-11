import java.awt.*;

/**
 * Volvo240 is a subclass to Car and holds all attributes a Volvo240 has.
 */
public class Volvo240 extends Car{
    /**
     * Volvo240 uses a constant trimFactor to calculate speed.
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240, calls the constructor of the superclass with appropriate arguments for a Volvo240
     */
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    /**
     * Method that defines the abstract method speedFactor from the superclass.
     * Calculates the speed Factor from a formula made for Volvo240.
     * @return The speed factor
     */
    @Override
    public double speedFactor(){
        double speedFactor = getEnginePower() * 0.01 * trimFactor;
        return speedFactor;
    }
}
