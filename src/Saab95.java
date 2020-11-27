import java.awt.*;

/**
 * Saab95 is a subclass to Car and holds all attributes a Saab95 has.
 */
public class Saab95 extends Car {
    /**
     * Saab95 has the individual attribute 'turbo' which can be turned on/off.
     * The state of the turbo affects the speed.
     */
    private boolean turboOn;

    /**
     * The constructor of Saab95.
     * This constructor inherits the constructor of the superclass with appropriate arguments of a Saab95.
     * It also turn the turbo off.
     */
    public Saab95() {
        super(2, Color.red, 100, "Saab95", 2);
        turboOn = false;
    }

    /**
     * Method to turn on the turbo.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Method to turn the turbo off.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Method that defines the abstract method speedFactor from the superclass.
     * Calculates the speed factor from a formula made for Saab95
     *
     * @return The speedFactor
     */
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        double speedFactor = getEnginePower() * 0.01 * turbo;
        return speedFactor;
    }
}
