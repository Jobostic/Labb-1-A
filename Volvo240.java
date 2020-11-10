import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    
    public Volvo240(Color color, int enginePower){
        super(4, color, enginePower, "Volvo240");
    }

    @Override
    public double speedFactor(){
        double speedFactor = getEnginePower()* 0.01 * trimFactor;
        return speedFactor;
    }

}
