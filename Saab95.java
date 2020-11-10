import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95( Color color, int enginePower){
        super(2, color, enginePower, "Saab95");
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
        double speedFactor = getEnginePower() * 0.01 * turbo;
        return speedFactor;
    }


}
