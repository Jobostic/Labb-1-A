import java.awt.*;

public abstract class Car implements Movable{

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double speedFactor; // Speedfactor depending on turbo and trimfactor.
    public double posX; // Every Cars position in x-direction
    public double posY; // Every Cars position in y-direction
    public int direction = getDirection(); // Every Cars direction
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
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

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getDirection(){
        return direction;
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
