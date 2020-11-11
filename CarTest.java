import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    void getNrDoors() {
        Volvo240 vol = new Volvo240(Color.black, 100);
        assertEquals(4, vol.getNrDoors());
    }

    @Test
    void setCurrentSpeed() {
        Volvo240 vol = new Volvo240(Color.black, 100);


    }

    @Test
    void getName() {
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void speedFactor() {
        Saab95 sab = new Saab95(Color.red, 100);
        sab.setTurboOn();
        assertEquals(1.3, sab.speedFactor());
    }

    @Test
    void incrementSpeed() {

    }

    @Test
    void decrementSpeed() {

    }

    @Test
    void gas() {
        Volvo240 vol = new Volvo240(Color.black, 100);
        vol.startEngine();
        vol.gas(0.5);
        assertEquals(0.725, vol.getCurrentSpeed() );

    }

    @Test
    void brake() {
        Saab95 sab = new Saab95(Color.red, 100);
        sab.setTurboOn();
        sab.startEngine();
        sab.brake(1);
        assertEquals(0, sab.getCurrentSpeed());
    }

    @Test
    void setDirection() {
    }

    @Test
    void getDirection() {
    }

    @Test
    void getX() {
    }

    @Test
    void getY() {
    }

    @Test
    void move() {
    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }
}