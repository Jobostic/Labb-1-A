import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    private garage<Car> cars;

    //private CarsModel cars;


    /*// Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarsModel cars) {
        //carImages = new HashMap<Car, BufferedImage>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;


    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars.getCarImages().keySet()) {
            g.drawImage(cars.getCarImages().get(car), (int) car.getX(), (int) car.getY(), null);
        }

    }*/

    public DrawPanel(int x, int y, garage cars) {
        //carImages = new HashMap<Car, BufferedImage>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;





    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars.getStorage()) {
            g.drawImage(car.getCarImage(), (int) car.getX(), (int) car.getY(), null);
        }

    }


}
