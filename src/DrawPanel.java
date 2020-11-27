import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
    ArrayList<Point> carPoints = new ArrayList<Point>();
    BufferedImage volvoImage;
    int distPic = 100;
    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    ArrayList<Car> cars;
    // TODO: Make this genereal for all cars

    /*void moveit(int x, int y){
        int k = 0;
        for(Car car: cars){
            int index = cars.indexOf(car);
            carPoints.get(index).x = x;
            carPoints.get(index).y = y + k;
            //volvoPoint.x = x;
            //volvoPoint.y = y + k;
            k += 100;
        }

    }*/

    /*void moveit(int x, int y) {
        for (Car car : cars) {
            car.setX(x + car.getY());
            car.setY(y + car.getX());
        }

    }*/

        /*for(Point p: carPoints){
            p.x = p.x + x;
            p.y = p.y + y;
        }*/


    /*public DrawPanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.


            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }*/
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.cars = cars;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            int k = 0;
            for (Car car : this.cars) {
                System.out.println(car.getName());
                images.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.getName() + ".jpg")));
                car.setY((int) car.getY() + k * distPic);
                car.setX(0);
                //carPoints.add(new Point(0,(int) car.getY()+k*distPic));
                k += 1;
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < images.size(); i++) {
            //g.drawImage(images.get(i), carPoints.get(i).x,(int) carPoints.get(i).y, null);
            g.drawImage(images.get(i), (int) cars.get(i).getX(), (int) cars.get(i).getY(), null);
        }

    }


    public static void main(String[] args) {
        ArrayList<Car> list = new ArrayList<>();
        list.add(new Volvo240());
        list.add(new Saab95());
        list.add(new Volvo240());
        System.out.println(Car.n);

        DrawPanel draw = new DrawPanel(800, 800, list);
        //draw.moveit(50,50);
        System.out.println(draw.images.get(0));
        for (Car car : draw.cars) {
            System.out.println(car.getName());
            System.out.println(car.getX());
            System.out.println(car.getY());
        }
        System.out.println();
        //draw.moveit(100,100);
        for (Car car : draw.cars) {
            System.out.println(car.getName());
            System.out.println(car.getX());
            System.out.println(car.getY());
        }
        System.out.println();
        /*
        System.out.println(draw.carPoints.get(0).x);
        System.out.println(draw.carPoints.get(0).y);
        System.out.println(draw.carPoints.get(1).x);
        System.out.println(draw.carPoints.get(1).y);
        System.out.println(draw.carPoints.get(2).x);
        System.out.println(draw.carPoints.get(2).y);

         */
        System.out.println(draw.images.size());
        System.out.println(draw.images.get(0));
        System.out.println(draw.images.get(1));
        System.out.println(draw.images.get(2));
    }
}
