/**
 * This interface is an abstract car factory. This is made so that the CarFactory class
 * does not break the open-closed principle. If new cars are added then a new factory is made
 * which implements this interface with the method generateCar. The reason for this, is that
 * the method in this interface takes a string and therefore needs a if-statement to check
 * the string that corresponds to the correct car model.
 */

interface AbstractCarFactory {

    public Car generateCar(String carWord);

}
