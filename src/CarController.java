import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());


    // The frame that represents this instance View of the MVC pattern
    private CarView view;
    private CarsModel cars;


    public CarController() {

    }

    public CarController(CarView view, CarsModel cars) {
        this.view = view;
        this.cars = cars;

    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars.getCarImages().keySet()) {
                if (car.getCurrentSpeed() > 0) {
                    car.move();
                    car.setX(car.getX());
                    car.setY(car.getY());

                    if (car.getX() > view.frame.getHeight()) {
                        cars.setBoundAndTurnCar(Car.WEST, car);
                    }

                    if (car.getX() < 0) {
                        cars.setBoundAndTurnCar(Car.EAST, car);
                    }


                    view.drawPanel.repaint();
                    view.carSpeedPanel.refresh();
                    view.carSpeedPanel.revalidate();

                }


            }
        }
    }

    public Timer getTimer() {
        return timer;
    }


}
