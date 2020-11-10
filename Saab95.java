import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, Color.red, 125, "Saab95");
	    turboOn = false;
    }

    private void setTurboOn(){
	    turboOn = true;
    }

    private void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        double speedFactor = enginePower * 0.01 * turbo;
        return speedFactor;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}