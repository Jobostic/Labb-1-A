import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.ArrayList;

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
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.cars.add(new Saab95());
        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania(Color.black, 200, "Scania", 5, 10));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
        System.out.println(cc.frame.getHeight());
        System.out.println(cc.frame.getWidth());
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    /*private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if(car.getCurrentSpeed() >0){
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    car.setX(car.getX());
                    car.setY(car.getY());
                    //frame.drawPanel.moveit(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }



            }
        }
    }*/


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (car.getCurrentSpeed() > 0) {
                    car.move();
                    int x = (int) Math.round(car.getX());
                    int y = (int) Math.round(car.getY());
                    car.setX(car.getX());
                    car.setY(car.getY());
                    if (x > frame.getHeight() - 100) {
                        setBoundAndTurnCar(3, car);
                    }

                    if (x < 0) {
                        setBoundAndTurnCar(1, car);
                    }
                    //frame.drawPanel.moveit(x, y);


                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                }
            }
        }
    }

    void setBoundAndTurnCar(int direction, Car car) {
        car.stopEngine();
        car.setDirection(direction);
        car.startEngine();
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }


    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }


    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftTrailer(double degrees) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).LiftTruckBed(degrees);
            }
        }
    }

    void lowerTrailer(double degrees) {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).LiftTruckBed(degrees);
            }
        }
    }


}
