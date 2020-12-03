import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class CarSimulator extends JFrame {

    public static void main(String[] args) {
        CarsModel cars = new CarsModel();
        cars.addCar("Volvo240");
        cars.addCar("Saab95");
        CarView view = new CarView("CarSim 1.0", cars);
        DrawPanel drawPanel = new DrawPanel(1000, 800-340, cars);
        CarSpeedPanel carSpeedPanel = new CarSpeedPanel(100,100, cars);
        //view.frame.add(drawPanel);


        CarController cc = new CarController(view, cars);
        cc.getTimer().start();

    }


}




