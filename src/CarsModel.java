import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CarsModel {


    private CarFactory carFactory = new CarFactory();
    private HashMap<Car, BufferedImage> carImages;
    private static int DIST_BETWEEN_PICS = 100;
    private static int nbrOfCars = 0;
    private int k = 0;

    public CarsModel() {
        carImages = new HashMap<Car, BufferedImage>();
    }

    public HashMap<Car, BufferedImage> getCarImages() {
        return carImages;
    }

    public void addCar(String carText) {

        if (carImages.size() < 10) {
            Car newCar = carFactory.generateCar(carText);
            if (!carImages.containsKey(newCar)) {
                try {

                    BufferedImage image = ImageIO.read(CarsModel.class.getResourceAsStream("pics/" + newCar.getName() + ".jpg"));
                    carImages.put(newCar, image);
                    if (newCar.getY() + nbrOfCars * DIST_BETWEEN_PICS < 500 && k == 0) {
                        newCar.setY(newCar.getY() + nbrOfCars * DIST_BETWEEN_PICS);
                        newCar.setX(0);
                        nbrOfCars++;
                    } else {
                        newCar.setY(newCar.getY() + k * DIST_BETWEEN_PICS);
                        newCar.setX(DIST_BETWEEN_PICS);
                        k++;
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            throw new IllegalArgumentException("There is no more room.");
        }


    }

    public void removeCar(String carWord) {
        ArrayList<Car> toRemove = new ArrayList<Car>();
        for (Car car : carImages.keySet()) {
            if (car.getName().equals(carWord)) {
                toRemove.add(car);
                nbrOfCars--;
            }
        }
        carImages.remove(toRemove.get(0));


    }

    void setBoundAndTurnCar(int direction, Car car) {
        car.stopEngine();
        car.setDirection(direction);
        car.startEngine();

    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : carImages.keySet()) {
            try {
                car.gas(gas);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : carImages.keySet()) {
            try {
                car.brake(brake);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }


    void startEngine() {
        for (Car car : carImages.keySet()) {
            try {
                car.startEngine();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }

    }


    void stopEngine() {
        for (Car car : carImages.keySet()) {
            car.stopEngine();
        }
    }

    void setTurboOn() {
        for (Car car : carImages.keySet()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
                System.out.println("Turbo is on");
            }
        }
    }

    void setTurboOff() {
        for (Car car : carImages.keySet()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
                System.out.println("Turbo is off");
            }
        }
    }

    void liftTrailer(double degrees) {
        for (Car car : carImages.keySet()) {
            if (car instanceof Scania) {
                ((Scania) car).LiftTruckBed(degrees);
                System.out.println("The truck bed position is at " + ((Scania) car).getTruckBed_pos() + " degrees");
            }
        }
    }

    void lowerTrailer(double degrees) {
        for (Car car : carImages.keySet()) {
            if (car instanceof Scania) {
                ((Scania) car).LowerTruckBed(degrees);
                System.out.println("The truck bed position is at " + ((Scania) car).getTruckBed_pos() + " degrees");
            }
        }
    }



}
