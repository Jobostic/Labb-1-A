import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView {
    private static final int X = 1000;
    private static final int Y = 800;



    JFrame frame = new JFrame();

    DrawPanel drawPanel;
    CarSpeedPanel carSpeedPanel;

    private CarModel cars;

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

    private String framename;

    /**
     * Sets the framename and CarModel. Furthermore it creates new objects of DrawPanel and CarSpeedPanel.
     *
     * @param framename
     * @param cars
     */
    public CarView(String framename, CarModel cars) {
        this.framename = framename;
        drawPanel = new DrawPanel(X, Y - 340, cars);
        carSpeedPanel = new CarSpeedPanel(X, 100, cars);
        this.cars = cars;
        initComponents(framename);

    }


    /**
     * Sets everything in place and fits everything
     *
     * @param title
     */

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


        /**
         * Actionlistener for button that adds a car. It takes in a string.
         * If the string is "" then a random car gets generated in CarFactory.
         * If the string is equal to one of the modelname of the existing cars
         * then it creates an object of that car in CarFactory.
         */

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.addCar(inputCarAdd.getText());
                drawPanel.repaint();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
                carSpeedPanel.repaint();


            }
        });

        /**
         * ActionListener for button that removes a car.
         */
        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.removeCar(inputCarRemove.getText());
                drawPanel.repaint();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
                carSpeedPanel.repaint();


            }
        });


        /**
         * ActionListener for the gas button.
         */
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.gas(gasAmount);
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
                carSpeedPanel.repaint();


            }
        });

        /**
         * ActionListener for the brake button.
         *
         */
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.brake(gasAmount);
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
                carSpeedPanel.repaint();

            }
        });

        /**
         * ActionListener for the start button.
         */

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.startEngine();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
                carSpeedPanel.repaint();


            }
        });

        /**
         * ActionListener for the stop button.
         */
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.stopEngine();
                carSpeedPanel.refresh();
                carSpeedPanel.revalidate();
                carSpeedPanel.repaint();

            }
        });

        /**
         * ActionListener for turbo ON button.
         */
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOn();
            }
        });

        /**
         * ActionListener for the turbo OFF button.
         */
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.setTurboOff();
            }
        });

        /**
         * ActionListener for the button that lifts the truck bed.
         */
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.liftTrailer();
            }
        });

        /**
         * ActionListener for the button that lowers the truck bed.
         */
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cars.lowerTrailer();
            }
        });


        /**
         * Make the frame pack all it's components by respecting the sizes if possible.
         */
        frame.pack();

        /**
         * Get the computer screen resolution
         */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        /**
         * Center the frame
         */
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        /**
         * Center the frame
         */
        frame.setVisible(true);
        /**
         *  Make sure the frame exits when "x" is pressed
         */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}