import java.util.Random;

public class CarFactory{

    public CarFactory(){

    }

    public Car generateCar(String carWord) {
            Random rand = new Random();
            int i = rand.nextInt(3);

            if (i == 0 || carWord.equals("Saab95")) {
                return new Saab95();
            } else if (i == 1 || carWord.equals("Volvo240")) {
                return new Volvo240();
            } else if (carWord.equals("Scania")) {
                return new Scania();
            } else {
                return new Scania();
            }

        }


}




