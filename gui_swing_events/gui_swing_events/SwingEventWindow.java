/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Areaf and Maria
 */

package gui_swing_events;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// Creating a SwingEventWindow class for the main application window.
public class SwingEventWindow extends JFrame implements ActionListener, ItemListener {

    // Setting up various components and fields.
    private JTextField inputField; // For user number input.
    private JTextField resultField; // For displaying the result.
    private JRadioButton rdoSum; // Radio button for sum calculation.
    private JRadioButton rdoAvg; // Radio button for average calculation.
    private JRadioButton rdoMax; // Radio button for maximum calculation.
    private JRadioButton rdoMin; // Radio button for minimum calculation.
    private ButtonGroup rdoGroup; // Group to manage radio button selection.
    private int rdoChecked; // Variable to track the selected radio button.


    // Constructor for the SwingEventWindow class.
    public SwingEventWindow() {
        // Setting up the main application window.

        
        super("Excel Formulas Window");
        setSize(800, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating panels for organizing components.
        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new GridLayout(1, 4));
        JPanel panel5 = new JPanel(new FlowLayout());
        JPanel panel6 = new JPanel(new FlowLayout());

        // Creating and configuring UI components (labels, buttons, and input fields).
        JLabel lblMain = new JLabel("Excel Functions");
        panel1.add(lblMain);

        JLabel lblRequest = new JLabel("Enter your numbers separated by spaces");
        panel2.add(lblRequest);
 
        inputField = new JTextField(20);
        panel3.add(inputField);

        rdoSum = new JRadioButton("Sum");
        rdoAvg = new JRadioButton("Avg");
        rdoMax = new JRadioButton("Max");
        rdoMin = new JRadioButton("Min");

        //attach and item listener
        rdoSum.addItemListener(this);
        rdoAvg.addItemListener(this);
        rdoMax.addItemListener(this);
        rdoMin.addItemListener(this);

        rdoGroup = new ButtonGroup();

        rdoGroup.add(rdoSum);
        rdoGroup.add(rdoAvg);
        rdoGroup.add(rdoMax);
        rdoGroup.add(rdoMin);

        panel4.add(rdoSum);
        panel4.add(rdoAvg);
        panel4.add(rdoMax);
        panel4.add(rdoMin);

        // Attaching action listeners and item listeners to components for handling user interactions.

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel5.add(calculateButton);

        JLabel resultLabel = new JLabel("Result:");
        panel6.add(resultLabel);

        resultField = new JTextField(20);
        resultField.setEditable(false);
        panel6.add(resultField);

        // Adding components to panels and panels to the mainPanel.
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(panel5);
        mainPanel.add(panel6);

        add(mainPanel);

    }

    // Item listener method to track radio button selection.
    public void itemStateChanged(ItemEvent e) {

        
        if (e.getSource() instanceof JRadioButton && e.getStateChange() == ItemEvent.SELECTED) 
        {
            // Identifying the selected radio button.
            JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
            
            if (selectedRadioButton == rdoSum) {
                rdoChecked = 1;
            } else if (selectedRadioButton == rdoAvg) {
                rdoChecked = 2;
            } else if (selectedRadioButton == rdoMax) {
                rdoChecked = 3;
            } else if (selectedRadioButton == rdoMin) {
                rdoChecked = 4;
            }
        }
    }
    
     // Action listener method to handle button click for calculation.
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof  JButton){

            // Handling user input, performing calculations based on the selected radio button, and displaying the result.
            String userInput = inputField.getText();
            
            Excel excel = new Excel(userInput);
            
            double result = 0.0;
            
            if (rdoChecked == 1) {
                result = excel.findTotal();
            } else if (rdoChecked == 2) {
                 result = excel.findAvg();
            } else if (rdoChecked == 3) {
                 result = excel.findMax();
            } else if (rdoChecked == 4) {
                 result = excel.findMin();
            }
            
            resultField.setText(String.valueOf(result));
        }
    }
}
