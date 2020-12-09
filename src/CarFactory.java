import java.util.Random;


/**
 * This class is a Factory class that creates car.
 * It can create Saab95, Scania and Volvo240.
 */
public class CarFactory {

    public CarFactory() {

    }


    /**
     * Generates car by taking in a string. If the string is "" then
     * the car is randomly generated. If a string is one of the model
     * name Scania, Volvo240 or Saab95 then it returns an object of
     * that car.
     *
     * @param carWord
     * @return
     */
    public Car generateCar(String carWord) {
        Random rand = new Random();
        int i = rand.nextInt(3);


        if (carWord.equals("Saab95")) {
            return new Saab95();
        } else if (carWord.equals("Volvo240")) {
            return new Volvo240();
        } else if (carWord.equals("Scania")) {
            return new Scania();
        } else if (i == 0) {
            return new Saab95();
        } else if (i == 1) {
            return new Volvo240();
        } else {
            return new Scania();
        }

    }
}




