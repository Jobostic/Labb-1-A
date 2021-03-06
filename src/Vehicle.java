import java.awt.*;

public class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double posX; // Every Cars position in x-direction
    private double posY; // Every Cars position in y-direction
    private int direction; // Every Cars direction
    public static final int NORTH = 0; // Dessa kan väl vara public?
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    private double weight; //in ton

    /**
     * Constructor of Car. Takes all important variables that are common to both Saab95 and Volvo240
     * @param nrDoors Amount of doors on the car.
     * @param color What color the Car has.
     * @param enginePower How powerful the engine is!
     * @param modelName Is it Volvo or is it SAAB?
     */
    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, double weight){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.direction = NORTH;
        this.posX = 0;
        this.posY = 0;
        this.weight = weight;
        stopEngine();
    }

    public Vehicle() {

    }

    /**
     * Getter for nrDoors.
     * @return
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Getter for enginePower
     * @return
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Setter for current speed
     * @param amount Decides what the speed will be set to.
     */

    public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;
    }

    /**
     * Getter for currentSpeed
     * @return
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Getter for model name.
     */
    public String getName(){
        return modelName;
    }


    /**
     * Getter for weight
     * @return
     */
    public double getWeight(){
        return weight;
    }


    /**
     * Getter for color
     * @return
     */
    public Color getColor(){
        return color;
    }

    /**
     * Setter for color
     * @param clr
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * When engine is started, the Car starts moving slowly.
     */
    public void startEngine(){
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
     * @return
     */
    public double speedFactor(){
        return getEnginePower() * 0.01;
    };

    /**
     * Increases the current speed by the amount multiplied by the speed factor.
     * Speed cannot exceed the enginepower.
     * @param amount Decides how much the speed will increase.
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decrease the current speed by the amount multiplied by the speed factor.
     * Speed cannot be negative.
     * @param amount Decides how much the speed will decrease.
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Method to increase the speed.
     * This method limits incrementSpeed() to increase the speed by at most the speedfactor every time the method is called.
     * It also makes it impossible for the car to go backwards when doing so.
     * If the argument lies outside the interval, an exception will be thrown.
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
     * @param amount The argument you send to decrementSpeed()
     */
    public void brake(double amount){
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
     * Method to set the car's direction before driving it.
     * @param direction Decides what direction the car will face.
     */
    private void setDirection(int direction){
        this.direction = direction;
    }

    /**
     * Getter for the car's direction.
     * @return
     */
    public int getDirection(){
        return direction;
    }

    /**
     * Getter for the car's x-coordinate
     * @return x-coordinate
     */
    public double getX(){
        return posX;
    }

    /**
     * Getter for the car's y-coordinate
     * @return y-coordinate
     */
    public double getY(){
        return posY;
    }

    /**
     * Setter for x-coordinate
     * @param posX x-coordinate
     */
    public void setX(double posX){
        this.posX = posX;
    } //osäker om den ska vara public eller private
    /**
     * Setter for y-coordinate
     * @param posY y-coordinate
     */
    public void setY(double posY){
        this.posY = posY;
    }


    /**
     * Method to make the car move in a x/y coordinate system.
     * Implemented from the interface Movable.
     * The position variables posX and posY increases/decreases depending on what direction the car faces and what the current speed of the car is att that moment.
     */

    public void move(){
        if(getCurrentSpeed() > 0){
            if(getDirection() == NORTH){
                posY = posY + getCurrentSpeed();
            }
            else if(getDirection() == EAST){
                posX = posX + getCurrentSpeed();
            }
            else if(getDirection() == SOUTH){
                posY = posY - getCurrentSpeed();
            }
            else if(getDirection() == WEST){
                posX = posX - getCurrentSpeed();
            }
        } else {
            throw new IllegalArgumentException("Turn on engine");
        }

    }

    /**
     * Method to change the car's direction 90° to the left.
     * Implemented from the interface Movable.
     */
    public void turnLeft(){
        if(getDirection() == NORTH){
            setDirection(WEST);
        }
        else if(getDirection() == EAST){
            setDirection(NORTH);
        }
        else if(getDirection() == SOUTH){
            setDirection(EAST);
        }
        else if(getDirection() == WEST){
            setDirection(SOUTH);
        }
    }

    /**
     * Method to change the car's direction 90° to the right.
     * Implemented from the interface Movable.
     */
    public void turnRight(){
        if(getDirection() == NORTH){
            setDirection(EAST);
        }
        else if(getDirection() == EAST){
            setDirection(SOUTH);
        }
        else if(getDirection() == SOUTH){
            setDirection(WEST);
        }
        else if(getDirection() == WEST){
            setDirection(NORTH);
        }
    }

}
