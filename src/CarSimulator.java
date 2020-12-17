
/**
 * This class is the application/simulator of the car and where the program is run.
 */
public class CarSimulator {

    public static void main(String[] args) {
        CarModel cars = new CarModel();

        /**
         * Can add cars before opening program if needed.
         */
        cars.addCar(new Volvo240());
        cars.addCar(new Saab95());
        cars.addCar(new Scania());

        CarLogger logger = new CarLogger();
        cars.addCarObserver(logger);
        CarView view = new CarView("CarSim 1.0", cars);

        CarController cc = new CarController(view, cars);


        cars.getTimer().start();
    }


}




