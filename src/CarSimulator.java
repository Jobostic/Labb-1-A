import javax.swing.*;


/**
 * This class is the application/simulator of the car and where the program is run.
 */
public class CarSimulator {

    public static void main(String[] args) {
        CarModel cars = new CarModel();

        /**
         * Can add cars before opening program if needed.
         */
        //cars.addCar("Volvo240");
        //cars.addCar("Saab95");

        CarView view = new CarView("CarSim 1.0", cars);

        CarController cc = new CarController(view, cars);

        cc.getTimer().start();

    }


}




