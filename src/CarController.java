import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    private CarView view;
    private CarModel cars;


    public CarController() {

    }

    /**
     * Initializes the view and model for the application.
     */
    public CarController(CarView view, CarModel cars) {
        this.view = view;
        this.cars = cars;
        actions();
        cars.addListenerTimer(new TimerListener());

    }


    /**
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images on the drawPanel and the speeds
     * on the carSpeedPanel. It also checks so that the car is within the frame.
     * If not then it turns the car around.
     */


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars.getCars()) {
                if (car.getCurrentSpeed() > 0) {
                    car.move();
                    car.setX(car.getX());
                    car.setY(car.getY());


                    if (car.getX() > view.drawPanel.getWidth() - view.getCarImages().get(car.getName()).getWidth()) {
                        cars.setBoundAndTurnCar(Car.WEST, car, car.getCurrentSpeed());
                    }

                    if (car.getX() < 0) {
                        cars.setBoundAndTurnCar(Car.EAST, car, car.getCurrentSpeed());
                    }


                    view.drawPanel.repaint();
                    view.carSpeedPanel.refresh();
                    view.carSpeedPanel.revalidate();
                    view.carSpeedPanel.repaint();

                }


            }
        }


    }


    /**
     * Method for all the actionListener
     * when pressing different buttons on the panel.
     */
    public void actions() {
        /**
         * Actionlistener for button that adds a car. It takes in a string.
         * If the string is "" then a random car gets generated in CarFactory.
         * If the string is equal to one of the modelname of the existing cars
         * then it creates an object of that car in CarFactory.
         */


        view.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car newCar = view.carFactory.generateCar(view.inputCarAdd.getText());
                //Car newCar = carFactory.generateCar(new Saab95());
                cars.addCar(newCar);
                view.addImage(newCar);
                view.drawPanel.repaint();
                view.carSpeedPanel.refresh();
                view.carSpeedPanel.revalidate();
                view.carSpeedPanel.repaint();


            }
        });

        /**
         * ActionListener for button that removes a car.
         */
        view.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.removeCar(view.inputCarRemove.getText());
                view.drawPanel.repaint();
                view.carSpeedPanel.refresh();
                view.carSpeedPanel.revalidate();
                view.carSpeedPanel.repaint();


            }
        });


        /**
         * ActionListener for the gas button.
         */
        view.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.gas(view.gasAmount);
                view.carSpeedPanel.refresh();
                view.carSpeedPanel.revalidate();
                view.carSpeedPanel.repaint();


            }
        });

        /**
         * ActionListener for the brake button.
         *
         */
        view.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.brake(view.gasAmount);
                view.carSpeedPanel.refresh();
                view.carSpeedPanel.revalidate();
                view.carSpeedPanel.repaint();

            }
        });

        /**
         * ActionListener for the start button.
         */

        view.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.startEngine();
                view.carSpeedPanel.refresh();
                view.carSpeedPanel.revalidate();
                view.carSpeedPanel.repaint();


            }
        });

        /**
         * ActionListener for the stop button.
         */
        view.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.stopEngine();
                view.carSpeedPanel.refresh();
                view.carSpeedPanel.revalidate();
                view.carSpeedPanel.repaint();

            }
        });

        /**
         * ActionListener for turbo ON button.
         */
        view.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOn();
            }
        });

        /**
         * ActionListener for the turbo OFF button.
         */
        view.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOff();
            }
        });

        /**
         * ActionListener for the button that lifts the truck bed.
         */
        view.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.liftTrailer();
            }
        });

        /**
         * ActionListener for the button that lowers the truck bed.
         */
        view.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.lowerTrailer();
            }
        });
    }

}
