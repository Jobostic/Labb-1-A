import java.awt.*;

/**
 * MyObject is a class for all objects. The objects have a position in x,y coordinate, weight and a color.
 */
public class MyObject {
    private double posX; // Every Cars position in x-direction
    private double posY; // Every Cars position in y-direction
    private double weight; //in ton
    private Color color; // Color of the object

    public MyObject() {

    }

    /**
     * Constructor that gives the object a color and weight.
     *
     * @param color
     * @param weight
     */
    public MyObject(Color color, double weight) {
        this.posX = 0;
        this.posY = 0;
        this.color = color;
        this.weight = weight;
    }


    /**
     * Setter for color
     *
     * @param clr
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Getter for color
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Getter for the object's x-coordinate
     *
     * @return
     */
    public double getX() {
        return posX;
    }

    /**
     * Getter for the object's y-coordinate
     *
     * @return y-coordinate
     */
    public double getY() {
        return posY;
    }

    /**
     * Setter for x-coordinate
     *
     * @param posX x-coordinate
     */
    public void setX(double posX) {
        this.posX = posX;
    } //osäker om den ska vara public eller private

    /**
     * Setter for y-coordinate
     *
     * @param posY y-coordinate
     */
    public void setY(double posY) {
        this.posY = posY;
    }

    /**
     * Getter for weight
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }


}
