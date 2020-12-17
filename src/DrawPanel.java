import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.*;

/**
 * This panel represent the animated part of the view with the car images.
 */


public class DrawPanel extends JPanel {


    private CarModel cars;
    private HashMap<String, BufferedImage> carImages;


    /**
     * Initializes the panel and cars.
     *
     * @param x
     * @param y
     * @param cars
     */
    public DrawPanel(int x, int y, CarModel cars, HashMap carImages) {
        this.carImages = carImages;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;


    }


    /**
     * This method is called each time the panel updates/refreshes/repaints itself
     *
     * @param g
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars.getCars()) {
            g.drawImage(carImages.get(car.getName()), (int) car.getX(), (int) car.getY(), null);
        }

    }


}
