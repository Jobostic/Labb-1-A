import java.awt.*;

public class Scania extends Truck {
    private double truckBed_pos;

    public Scania(Color color, double enginePower, String modelName, double weight){
        super(2, color, enginePower, modelName, weight );
    }

    public double getTruckBed_pos(){
        return truckBed_pos;
    }


<<<<<<< HEAD
    public void startEngineTruck(){
        if(truckBed_pos == 0){
            startEngine();
        }
    }


=======
>>>>>>> 036682f5eb28dcaa59a873d02cf9bfb2596542da

    public void SetLiftTruckBed(double degree){
        if(getCurrentSpeed() == 0 && truckBed_pos + degree <= 70){
            truckBed_pos += degree;
        } else if(getCurrentSpeed() != 0){
            throw new IllegalArgumentException("The car is moving.");
        } else{
            throw new IllegalArgumentException("The angle has to be lower than 70 degrees");
        }
    }

    public void SetLowerTruckBed(double degree){
        if(getCurrentSpeed() == 0 && truckBed_pos - degree >= 0){
            truckBed_pos -= degree;
        } else if(getCurrentSpeed() != 0){
            throw new IllegalArgumentException("The car is moving.");
        } else{
            throw new IllegalArgumentException("The angle has to be higher than 0 degrees");
        }
    }

    public void truckBedStorage(){

    }


    @Override
    public void startEngine() {
        if(truckBed_pos == 0){
            setCurrentSpeed(0.1);
        }

    }
}
