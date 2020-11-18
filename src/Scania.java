import java.awt.*;
import java.util.LinkedList;

public class Scania extends CarTransport {
    private double truckBed_pos;
    LinkedList<Object> storage;

    public Scania(){

    }

    public Scania(Color color, double enginePower, String modelName, double weight, int maxStorage){
        super(2, color, enginePower, modelName, weight, maxStorage );
        storage = new LinkedList<Object>();
    }

    public double getTruckBed_pos(){
        return truckBed_pos;
    }


    @Override
    public void startEngine(){
        if(truckBed_pos == 0){
            setCurrentSpeed(0.1);
        }
    }




    public void LiftTruckBed(double degree){
        if(degree > 0){
            if(getCurrentSpeed() == 0 && truckBed_pos + degree <= 70){
                truckBed_pos += degree;
            } else if(getCurrentSpeed() != 0){
                throw new IllegalArgumentException("The car is moving.");
            } else{
                throw new IllegalArgumentException("The angle has to be lower than 70 degrees");
            }
        } else {
            throw new IllegalArgumentException("Has to be positive");
        }

    }

    public void LowerTruckBed(double degree){
        if(degree > 0){
            if(getCurrentSpeed() == 0 && truckBed_pos - degree >= 0){
                truckBed_pos -= degree;
            } else if(getCurrentSpeed() != 0){
                throw new IllegalArgumentException("The car is moving.");
            } else{
                throw new IllegalArgumentException("The angle has to be higher than 0 degrees");
            }
        } else {
            throw new IllegalArgumentException("Has to be positive");
        }

    }


    public void addObject(Object o){
        if(storage.size() < getMaxStorage()){
            storage.add(o);
        }
    }



}
