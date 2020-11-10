import java.awt.*;

public abstract class Car implements Movable{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double speedFactor; // Speedfactor depending on turbo and trimfactor.
    private double posX; // Every Cars position in x-direction
    private double posY; // Every Cars position in y-direction
    private int direction; // Every Cars direction
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.direction = NORTH;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public void setCurrentSpeed(double amount){
        this.currentSpeed = amount;


    }

    public String getName(){
        return modelName;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if(0 <= amount && amount <= 1){
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Values have to be in interval [0,1]");
        }

    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if(0 <= amount && amount <= 1){
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Values have to be in interval [0,1]");
        }


    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getDirection(){
        return direction;
    }

    public double getX(){
        return posX;
    }

    public double getY(){
        return posY;
    }

    @Override
    public void move(){
        if(direction == NORTH){
            posY = posY + getCurrentSpeed();
        }
        if(direction == EAST){
            posX = posX + getCurrentSpeed();
        }
        if(direction == SOUTH){
            posY = posY - getCurrentSpeed();
        }
        if(direction == WEST){
            posX = posX - getCurrentSpeed();
        }
    }

    @Override
    public void turnLeft(){
        if(direction == NORTH){
            setDirection(WEST);
        }
        if(direction == EAST){
            setDirection(NORTH);
        }
        if(direction == SOUTH){
            setDirection(EAST);
        }
        if(direction == WEST){
            setDirection(SOUTH);
        }
    }

    @Override
    public void turnRight(){
        if(direction == NORTH){
            setDirection(EAST);
        }
        if(direction == EAST){
            setDirection(SOUTH);
        }
        if(direction == SOUTH){
            setDirection(WEST);
        }
        if(direction == WEST){
            setDirection(NORTH);
        }
    }
}
