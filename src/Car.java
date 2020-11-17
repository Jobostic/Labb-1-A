import java.awt.*;

/**
 * An abstract class used to gather common attributes of classes Volvo240 and Saab95.
 * Also implements interface Movable which allows the cars you create to move and turn.
 */
public abstract class Car extends Vehicle{

    public Car(){

    }

    public Car(int nrDoors, Color color, double enginePower, String modelName, double weight){
        super(nrDoors, color, enginePower, modelName, weight);
    }


}
