import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, Color.black, 100, "Volvo240");
    }

    @Override
    public double speedFactor(){
        double speedFactor = enginePower * 0.01 * trimFactor;
        return speedFactor;
    }

    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}