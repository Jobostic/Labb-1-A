import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CarSpeedPanel extends JPanel {
    private garage<Car> cars;


    /*public CarSpeedPanel(int x, int y, CarsModel cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.cars = cars;
        this.setLayout(new GridLayout(2, 5));

        int k = 0;
        for (Car car : this.cars.getCarImages().keySet()) {
            JLabel label = new JLabel();
            label.setText(car.getName() + ": " + car.getCurrentSpeed() + "km/h");
            this.add(label, k);
            k++;
        }


    }*/

    /*public CarSpeedPanel(int x, int y, garage cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.cars = cars;
        this.setLayout(new GridLayout(2, 5));

        int k = 0;
        for (Car car : this.cars.getCarImages().keySet()) {
            JLabel label = new JLabel();
            label.setText(car.getName() + ": " + car.getCurrentSpeed() + "km/h");
            this.add(label, k);
            k++;
        }


    }*/


    public CarSpeedPanel(int x, int y, garage<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
        this.cars = cars;
        this.setLayout(new GridLayout(2, 5));

        int k = 0;


        for (Car car : cars.getStorage()) {
            JLabel label = new JLabel();
            label.setText(car.getName() + ": " + car.getCurrentSpeed() + "km/h");
            this.add(label, k);
            k++;
        }




    }

    /*public void refresh() {
        this.removeAll();
        int k = 0;
        for (Car car : this.cars.getCarImages().keySet()) {
            JLabel label = new JLabel();
            String currentSpeed = String.format("%.2f", car.getCurrentSpeed());
            label.setText(car.getName() + ": " + currentSpeed + " " + "km/h");
            this.add(label, k);
            k++;
        }
    }*/

    public void refresh() {
        this.removeAll();
        int k = 0;
        for (Car car : cars.getStorage()) {
            JLabel label = new JLabel();
            String currentSpeed = String.format("%.2f", car.getCurrentSpeed());
            label.setText(car.getName() + ": " + currentSpeed + " " + "km/h");
            this.add(label, k);
            k++;
        }
    }


    public static void main(String[] args) {


    }


}
