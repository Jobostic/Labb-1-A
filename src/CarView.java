import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView {
    private static final int X = 1000;
    private static final int Y = 800;
    private static final double degrees = 35;

    private CarFactory carFactory = new CarFactory();

    JFrame frame = new JFrame();

    DrawPanel drawPanel;
    CarSpeedPanel carSpeedPanel;

    private garage<Car> cars;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    JTextField inputCarAdd = new JTextField(10);

    JTextField inputCarRemove = new JTextField(10);


    // Constructor
   /* public CarView(String framename, CarsModel cars) {
        drawPanel = new DrawPanel(X, Y - 340, cars);
        carSpeedPanel = new CarSpeedPanel(X, 100, cars);
        this.cars = cars;
        initComponents(framename);

    }*/

    public CarView(String framename, garage<Car> cars) {
        drawPanel = new DrawPanel(X, Y - 340, cars);
        carSpeedPanel = new CarSpeedPanel(X, 100, cars);
        this.cars = cars;
        initComponents(framename);

    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(X, Y));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        frame.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        inputCarAdd.setToolTipText("Car to add");
        inputCarRemove.setToolTipText("Car to remove");

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(removeCarButton, 3);
        controlPanel.add(inputCarRemove, 4);
        controlPanel.add(brakeButton, 5);
        controlPanel.add(turboOffButton, 6);
        controlPanel.add(lowerBedButton, 7);
        controlPanel.add(addCarButton, 8);
        controlPanel.add(inputCarAdd, 9);


        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        frame.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        frame.add(stopButton);

        frame.add(carSpeedPanel);


        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.addCar(carFactory.generateCar(inputCarAdd.getText()));
                drawPanel.repaint();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.removeCar(inputCarRemove.getText());
                drawPanel.repaint();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();

            }
        });


        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Car car: cars.getStorage()){
                    car.gas((double)gasAmount/100);
                }
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });



        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Car car: cars.getStorage()){
                    car.brake((double ) gasAmount/100);
                }
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Car car: cars.getStorage()){
                    car.startEngine();
                }

                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();

            }
        });




        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(Car car: cars.getStorage()){
                    car.stopEngine();
                }
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });

        /*turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.liftTrailer(degrees);
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.lowerTrailer(degrees);
            }
        });

        */


        /*gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.gas(gasAmount);
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.brake(gasAmount);
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.startEngine();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();

            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.stopEngine();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.liftTrailer(degrees);
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.lowerTrailer(degrees);
            }
        });
    */

        // Make the frame pack all it's components by respecting the sizes if possible.
        frame.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        // Make the frame visible
        frame.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}