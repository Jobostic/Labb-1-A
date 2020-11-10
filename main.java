import java.awt.*;

public class main {

    public static void main(String[] args){
        Volvo240 vol = new Volvo240(Color.black, 100);
        vol.incrementSpeed(10);
        System.out.println(vol.getCurrentSpeed());
        Saab95 sab = new Saab95(Color.red, 100);
        sab.incrementSpeed(10);
        System.out.println(sab.getCurrentSpeed());
    }
}
