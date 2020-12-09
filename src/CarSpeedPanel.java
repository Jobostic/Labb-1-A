import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

/**
 * This panel represents the animated part of the view with the speed of the cars.
 */

public class CarSpeedPanel extends JPanel {
    private CarModel cars;


    /**
     * Initializes the panel and adds the labels of the cars that are initialized
     * before opening the simulator.
     *
     * @param x
     * @param y
     * @param cars
     */
    public CarSpeedPanel(int x, int y, CarModel cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

        this.cars = cars;
        this.setLayout(new GridLayout(cars.getNbrOfRows(), cars.getNbrOfCol()));

        int indexOfLabel = 0;
        for (Car car : this.cars.getCars()) {
            JLabel label = new JLabel();
            label.setText(car.getName() + ": " + car.getCurrentSpeed() + "km/h");
            this.add(label, indexOfLabel);
            indexOfLabel++;
        }

    }


    /**
     * This is called at actionsListener gas, brake etc. in CarView. Starts of by removing all the previous
     * components on the panel and then it creates labels with the new speed of the cars
     * and adds them to the panel.
     */
    public void refresh() {
        this.removeAll();
        int indexOfLabel = 0;

        if (!cars.getCars().isEmpty()) {
            for (Car car : cars.getCars()) {
                JLabel label = new JLabel();
                String currentSpeed = String.format("%.2f", car.getCurrentSpeed());
                label.setText(car.getName() + ": " + currentSpeed + " " + "km/h");
                this.add(label, indexOfLabel);
                indexOfLabel++;
            }
        }


    }


}
