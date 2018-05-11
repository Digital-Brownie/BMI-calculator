/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examq4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ypcc14zw8
 */
public class GUI extends JFrame {
    
    double height, weight, BMI;
    
        
    JLabel lblWeight, lblHeight, message, bmi;
    JTextField txtWeight, txtHeight;
    JRadioButton male, female;
    JButton calculate;
    
    public GUI()
    {
        super("BMI calculator");
        
        setLayout(new GridLayout(6,2,1,1));
        
        lblWeight = new JLabel("Enter weight: ");
        add(lblWeight);
        txtWeight = new JTextField(10);
        add(txtWeight);
        lblHeight = new JLabel("Enter height: ");
        add(lblHeight);
        txtHeight = new JTextField(10);
        add(txtHeight);
        
        male = new JRadioButton("male");
        add(male);
        female = new JRadioButton("female");
        add(female);
        
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        
        calculate = new JButton("calculate");
        add(calculate);
        
        bmi = new JLabel();
        add(bmi);
        message = new JLabel();
        add(message);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,200);
        setVisible(true);
        
        actionHandler handler = new actionHandler();
        
        calculate.addActionListener(handler);
        
    }
    
    class actionHandler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
                weight = Double.parseDouble(txtWeight.getText());
                height = Double.parseDouble(txtHeight.getText());
                
                BMI = weight/(height*height);
                
                bmi.setText("Your BMI is: " + BMI);
                
                if (male.isSelected()) {
                    if (BMI < 22.5) {
                        message.setText("You are under weight");
                    }
                    else if (BMI > 22.5 && BMI <= 29.5 ) {
                        message.setText("You are the ideal weight");
                    }
                    else if (BMI > 29.5 && BMI > 32.9) {
                        message.setText("You are overweight");
                    }
                    else if (BMI > 33) {
                        message.setText("You are obese");
                    }
                    
            }
                if (female.isSelected()) {
                    if (BMI < 18.5) {
                        message.setText("You are under weight");
                    }
                    else if (BMI > 18.5 && BMI < 24.5 ) {
                        message.setText("You are the ideal weight");
                    }
                    else if (BMI > 24.5 && BMI > 29.9) {
                        message.setText("You are overweight");
                    }
                    else if (BMI > 30) {
                        message.setText("You are obese");
                    }
                
            }
            
        }
        
    }
    
    
}
