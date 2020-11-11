import java.awt.*;

public class main {

    public static void main(String[] args){
        Volvo240 vol = new Volvo240(Color.black, 100);

        System.out.println(vol.getCurrentSpeed());
        Saab95 sab = new Saab95(Color.red, 100);
        sab.gas(2);
        System.out.println();

        System.out.println(sab.getCurrentSpeed());
    }
}
