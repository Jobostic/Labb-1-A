import java.awt.*;

public abstract class CarTransport extends Car{
    private int maxStorage;

    public CarTransport(){

    }

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, double weight, int maxStorage){
        //super(nrDoors, color, enginePower, modelName, weight);
        this.maxStorage = maxStorage;
    }


    public int getMaxStorage(){
        return maxStorage;
    }

    public void setMaxStorage(int maxStorage){
        this.maxStorage = maxStorage;
    }

    public static double measureDist(double x, double y){
        return Math.abs(x-y);
    }


}
