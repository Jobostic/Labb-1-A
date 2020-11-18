import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;
import org.junit.Before;

public class CarTest {

     private Volvo240 volvo = new Volvo240();
     private Saab95 saab = new Saab95();
     private WheelerTruck truck1 = new WheelerTruck(Color.black, 100, "Wheeler", 5, 10);
     private Scania scania = new Scania(Color.red, 100, "Scania", 5, 10);
     private garage<Car> gar = new garage<Car>(10);

    private Object IllegalArgumentException;

    @Test
    public void TestAddCar(){
        gar.addCar(volvo);
        assertEquals(volvo, gar.getCar(0));
    }

    @Test
    public void TestMove(){
        truck1.startEngine();
        truck1.move();
        truck1.stopEngine();
        truck1.SetRampDown();
        truck1.loadCars(volvo);
        truck1.loadCars(saab);
        truck1.SetRampUp();
        truck1.startEngine();
        truck1.move();
        truck1.turnLeft();
        truck1.move();
        truck1.move();
        assertEquals(-0.2, saab.getX(),0);
    }

    @Test
    public void TestLoadCars(){
        truck1.SetRampDown();
        truck1.loadCars(volvo);
        truck1.loadCars(saab);
        assertEquals(volvo, truck1.getCar(0));

    }

    @Test
    public void TestLiftTruckBedScania(){
        scania.LiftTruckBed(10);
        assertEquals(10, scania.getTruckBed_pos(),0);
    }

    @Test
    public void checkRightAmountOfDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void checkingCurrentSpeed() {
        volvo.startEngine();
        assertEquals(0.1,volvo.getCurrentSpeed(),0);

    }

    @Test
    public void checkIfGettingName() {
        assertEquals("Volvo240",volvo.getName());
    }

    @Test
    public void checkIfGettingEnginePower() {
        assertEquals(100,volvo.getEnginePower(),0);
    }

    @Test
    public void checkIfGettingCurrentSpeed() {
        volvo.startEngine();
        volvo.gas(1);
        volvo.gas(1);
        volvo.brake(0.5);
        assertEquals(1.975,volvo.getCurrentSpeed(),0);
    }

    @Test
    public void checkIfGettingColor() {
        assertEquals(Color.black, volvo.getColor());
    }

    @Test
    public void checkIfEngineStarted() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(),0);
    }

    @Test
    public void checkIfEngineStopped() {
        volvo.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(),0);
        volvo.stopEngine();
        assertEquals(0,volvo.getCurrentSpeed(),0);
    }

    @Test
    public void checkIfSpeedFactorChanges() {
        assertEquals(1.25,volvo.speedFactor(),0);
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor(),0);
        saab.setTurboOff();
        assertEquals(1.25,saab.speedFactor(),0);
    }

    @Test
    public void checkIfGasCorrect() {
        volvo.startEngine();
        volvo.gas(1);
        assertEquals(1.35,volvo.getCurrentSpeed(),0);
    }

    @Test
    public void checkIfBrakeCorrect() {
        volvo.startEngine();
        volvo.gas(1);
        volvo.brake(0.1);
        assertEquals(1.225,volvo.getCurrentSpeed(),0);
    }

    @Test
    public void checkIfGettingX() {
        assertEquals(0,volvo.getX(),0);
        volvo.turnRight();
        volvo.startEngine();
        volvo.move();
        assertEquals(0.1,volvo.getX(),0);
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.move();
        assertEquals(0,volvo.getX(),0);
    }

    @Test
    public void checkIfGettingY() {
        assertEquals(0,volvo.getY(),0);
        volvo.startEngine();
        volvo.move();
        assertEquals(0.1,volvo.getY(),0);
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.move();
        assertEquals(0,volvo.getY(),0);
    }

    @Test
    public void doesCarMove() {
        volvo.startEngine();
        volvo.move();
        assertEquals(0.1, volvo.getY(), 0.001);
        volvo.gas(1);
        volvo.move();
        assertEquals(1.45,volvo.getY(),0.001);
        volvo.turnRight();
        volvo.brake(0.5);
        volvo.move();
        assertEquals(0.725,volvo.getX(),0.001);

    }

    @Test
    public void testIfTurningLeft() {
        volvo.turnLeft();
        assertEquals(3, volvo.getDirection());
        saab.turnLeft();
        saab.turnLeft();
        assertEquals(2,saab.getDirection());
    }

    @Test
    public void testIfTurningRight() {
        saab.turnRight();
        saab.turnRight();
        assertEquals(2, saab.getDirection());
    }
}
