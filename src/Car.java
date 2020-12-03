import java.awt.*;

/**
 * An abstract class used to gather common attributes of classes Volvo240 and Saab95.
 * Also implements interface Movable which allows the cars you create to move and turn.
 */
public abstract class Car extends MyObject implements Movable {

    public static final int NORTH = 0; //
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private String modelName; // The car model name
    private int direction; // Every Cars direction
    protected static int n = 0;
    private static int x = 1;

    /**
     * Constructor of Car. Takes all important variables that are common to both Saab95 and Volvo240
     *
     * @param nrDoors     Amount of doors on the car.
     * @param color       What color the Car has.
     * @param enginePower How powerful the engine is!
     * @param modelName   Is it Volvo or is it SAAB?
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName, double weight) {
        super(color, weight);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.direction = EAST;
        n += 1;
    }

    public Car() {
    }

    /**
     * Getter for nrDoors.
     *
     * @return
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Getter for enginePower
     *
     * @return
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Getter for currentSpeed
     *
     * @return
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Setter for current speed
     *
     * @param amount Decides what the speed will be set to.
     */

    public void setCurrentSpeed(double amount) {
        this.currentSpeed = amount;
    }

    /**
     * Getter for model name.
     */
    public String getName() {
        return modelName;
    }


    /**
     * When engine is started, the Car starts moving slowly.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * When engine is turned off, the Car stops moving.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * An abstract method to calculate the speed factor.
     * Speed factor is an attribute of both Saab95 and Volvo240 but it is calculated differently.
     *
     * @return
     */
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    ;

    /**
     * Increases the current speed by the amount multiplied by the speed factor.
     * Speed cannot exceed the enginepower.
     *
     * @param amount Decides how much the speed will increase.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decrease the current speed by the amount multiplied by the speed factor.
     * Speed cannot be negative.
     *
     * @param amount Decides how much the speed will decrease.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Method to increase the speed.
     * This method limits incrementSpeed() to increase the speed by at most the speedfactor every time the method is called.
     * It also makes it impossible for the car to go backwards when doing so.
     * If the argument lies outside the interval, an exception will be thrown.
     *
     * @param amount The argument you send to incrementSpeed()
     */
    public void gas(double amount) {
        if (getCurrentSpeed() > 0) {
            if (0 <= amount && amount <= 1) {
                incrementSpeed(amount);
            } else {
                throw new IllegalArgumentException("Values have to be in interval [0,1]");
            }
        } else {
            throw new IllegalArgumentException("Start engine first");
        }
    }

    /**
     * Method to decrease the speed.
     * This method limits decrementSpeed() to decrease the speed by at most the speedfactor every time the method is called.
     * It also makes it impossible for the car to go forward when doing so.
     * If the argument lies outside the interval, an exception will be thrown.
     *
     * @param amount The argument you send to decrementSpeed()
     */
    public void brake(double amount) {
        if (getCurrentSpeed() > 0) {
            if (0 <= amount && amount <= 1) {
                decrementSpeed(amount);
            } else {
                throw new IllegalArgumentException("Values have to be in interval [0,1]");
            }
        } else {
            throw new IllegalArgumentException("The car is not moving");
        }
    }

    /**
     * Getter for the car's direction.
     *
     * @return
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Method to set the car's direction before driving it.
     *
     * @param direction Decides what direction the car will face.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Method to make the car move in a x/y coordinate system.
     * Implemented from the interface Movable.
     * The position variables posX and posY increases/decreases depending on what direction the car faces and what the current speed of the car is att that moment.
     */

    public void move() {
        //if (getCurrentSpeed() > 0) {
            if (getDirection() == NORTH) {
                setY(getY() + getCurrentSpeed());
            } else if (getDirection() == EAST) {
                setX(getX() + getCurrentSpeed());
            } else if (getDirection() == SOUTH) {
                setY(getY() - getCurrentSpeed());
            } else if (getDirection() == WEST) {
                setX(getX() - getCurrentSpeed());
            }
       /* } else {
            throw new IllegalArgumentException("Turn on engine");
        }*/

    }

    /**
     * Method to change the car's direction 90° to the left.
     * Implemented from the interface Movable.
     */
    public void turnLeft() {
        if (getDirection() == NORTH) {
            setDirection(WEST);
        } else if (getDirection() == EAST) {
            setDirection(NORTH);
        } else if (getDirection() == SOUTH) {
            setDirection(EAST);
        } else if (getDirection() == WEST) {
            setDirection(SOUTH);
        }
    }

    /**
     * Method to change the car's direction 90° to the right.
     * Implemented from the interface Movable.
     */
    public void turnRight() {
        if (getDirection() == NORTH) {
            setDirection(EAST);
        } else if (getDirection() == EAST) {
            setDirection(SOUTH);
        } else if (getDirection() == SOUTH) {
            setDirection(WEST);
        } else if (getDirection() == WEST) {
            setDirection(NORTH);
        }
    }





}
