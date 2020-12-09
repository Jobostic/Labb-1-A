import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents the Model part in the MVC pattern.
 * It manages the data, logic and rules of the application.
 */

public class CarModel {

    private final int maxStorage = 10;
    private static final double degrees = 35;
    private ArrayList<Car> cars;
    private CarFactory carFactory = new CarFactory();
    private HashMap<String, BufferedImage> carImages;
    private final static int DIST_BETWEEN_PICS = 100;
    private final int nbrOfCol = 2;
    private final int nbrOfRows = maxStorage / nbrOfCol;
    private Car[][] carPosition;


    /**
     * Initializes the images of the cars, the list that stores the cars and the matrix
     * that stores the position of the car on the drawPanel.
     */
    public CarModel() {
        carImages = new HashMap<String, BufferedImage>();
        cars = new ArrayList<Car>();
        carPosition = new Car[nbrOfRows][nbrOfCol];
    }


    /**
     * Returns a HashMap of the car images.
     *
     * @return
     */
    public HashMap<String, BufferedImage> getCarImages() {
        return carImages;
    }


    /**
     * Returns a list of cars.
     *
     * @return
     */
    public ArrayList<Car> getCars() {
        return cars;
    }


    /**
     * Adds the picture that corresponds to the model name of the car in CarImages, given that
     * it does not contain it already.
     *
     * @param newCar
     */
    public void addImage(Car newCar) {
        if (!carImages.containsKey(newCar.getName())) {
            try {
                BufferedImage image = ImageIO.read(CarModel.class.getResourceAsStream("pics/" + newCar.getName() + ".jpg"));
                carImages.put(newCar.getName(), image);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Adds car to the arraylist. It takes in a string of the model name and checks
     * first if there is room. If there is, it generates a car, adds it to the
     * arraylist, sets the position of the car and lastly adds it picture.
     *
     * @param carText
     */
    public void addCar(String carText) {

        if (cars.size() < maxStorage) {
            Car newCar = carFactory.generateCar(carText);
            cars.add(newCar);
            setCarPosition(newCar);
            addImage(newCar);
        } else {
            throw new IllegalArgumentException("There is no more room.");
        }


    }


    /**
     * Removes a car from the list. It takes in a string of the model name.
     *
     * @param carWord
     */
    public void removeCar(String carWord) {
        ArrayList<Car> toRemove = new ArrayList<Car>();
        toRemove.add(removeCarPosition(carWord));
        cars.remove(toRemove.get(0));

    }


    /**
     * Help method that sets the position of the cars in matrix carPosition.
     * It is suppose to make sure that the car that is added to the panel
     * gets placed in the first available position on the drawPanel.
     *
     * @param newCar
     */
    public void setCarPosition(Car newCar) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (carPosition[j][i] == null) {
                    newCar.setY(newCar.getY() + j * DIST_BETWEEN_PICS);
                    newCar.setX(i * DIST_BETWEEN_PICS);
                    carPosition[j][i] = newCar;
                    return;
                }
            }
        }
    }

    /**
     * Removes the car from the carPosition and returns the car
     * that is getting removed.
     *
     * @param carWord
     * @return
     */
    public Car removeCarPosition(String carWord) {
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 5; j++) {
                if (carPosition[j][k] == null) {
                    continue;
                } else if (carWord.equals("")) {
                    Car carTemp = carPosition[j][k];
                    carPosition[j][k] = null;
                    return carTemp;
                } else if (carPosition[j][k].getName().equals(carWord)) {
                    Car carTemp = carPosition[j][k];
                    carPosition[j][k] = null;
                    return carTemp;
                }

            }
        }
        return null;
    }


    /**
     * Help method for when the car reaches the end of the frame.
     * Stops the engine, changes direction and starts the engine again.
     *
     * @param direction
     * @param car
     */
    public void setBoundAndTurnCar(int direction, Car car) {
        car.stopEngine();
        car.setDirection(direction);
        car.startEngine();

    }


    /**
     * Increases the speed of all cars by amount/100.
     *
     * @param amount
     */
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            try {
                car.gas(gas);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Decreases the speed of the all the cars by amount/100.
     *
     * @param amount
     */
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            try {
                car.brake(brake);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Starts the engine of all the cars that are standing still.
     */
    public void startEngine() {
        for (Car car : cars) {
            if (car.getCurrentSpeed() == 0) {
                try {
                    car.startEngine();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }

            }

        }
    }


    /**
     * Stops the engine of all cars.
     */
    public void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }


    /**
     * Turns on the turbo on all Saab95.
     */
    public void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
                System.out.println("Turbo is on");
            }
        }
    }

    /**
     * Turns off the turbo on all Saab95
     */
    public void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
                System.out.println("Turbo is off");
            }
        }
    }


    /**
     * Returns the degrees that the trailer gets lowered/lifted by.
     */

    public double getDegrees(){
        return degrees;
    }

    /**
     * Lifts the trailer by degrees on all Scanias.
     *
     */
    public void liftTrailer() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).LiftTruckBed(degrees);
                System.out.println("The truck bed position is at " + ((Scania) car).getTruckBed_pos() + " degrees");
            }
        }
    }

    /**
     * Lowers the trailer by degrees on all Scanias.
     *
     */
    public void lowerTrailer() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).LowerTruckBed(degrees);
                System.out.println("The truck bed position is at " + ((Scania) car).getTruckBed_pos() + " degrees");
            }
        }
    }


    /**
     * Returns the number of columns of the grid carPosition.
     */
    public int getNbrOfCol() {
        return nbrOfCol;
    }

    /**
     * Returns the number of rows of the grid carPosition.
     */
    public int getNbrOfRows() {
        return nbrOfRows;
    }

}
