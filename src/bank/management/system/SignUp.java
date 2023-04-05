package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser; 
import java.awt.event.*;

/*
 * @author Manish Kumar
 */
public class SignUp extends JFrame implements ActionListener{
    
    JTextField nameTextField, fatherNameTextField, emailAddressTextField, addressTextField, cityTextField, pinCodeTextField, stateTextField; 
    JRadioButton male, female, married,unmarried,divorced; 
    JDateChooser dateOfBirthTextField;
    JButton next, cancel;
    long number;
    String formno;
    SignUp(String formno){
        this.formno =formno;
        Random randomFormNo = new Random();
        number = Math.abs((randomFormNo.nextLong() % 9000L) + 1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO: " + number);
        formNo.setFont(new Font("Osward", Font.BOLD, 38));
        formNo.setBounds(200, 30, 600, 40);
        add(formNo);
        
        JLabel personalDetails = new JLabel("Page 1: Personsal Details");
        personalDetails.setFont(new Font("Osward", Font.BOLD, 22));
        personalDetails.setBounds(290, 90, 300, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:*");
        name.setFont(new Font("Osward", Font.BOLD, 20));
        name.setBounds(200, 140, 200, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(400, 140, 250, 30);
        add(nameTextField);
        
        JLabel fatherName = new JLabel("Father Name:*");
        fatherName.setFont(new Font("Osward", Font.BOLD, 20));
        fatherName.setBounds(200, 180, 200, 30);
        add(fatherName);
        
        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(400, 180, 250, 30);
        add(fatherNameTextField);
        
        JLabel dateOfBirth = new JLabel("Date Of Birth:*");
        dateOfBirth.setFont(new Font("Osward", Font.BOLD, 20));
        dateOfBirth.setBounds(200, 220, 200, 30);
        add(dateOfBirth);
        
        dateOfBirthTextField = new JDateChooser();
        dateOfBirthTextField.setBounds(400, 220, 250, 30);
        add(dateOfBirthTextField);
        
        JLabel gender = new JLabel("Gender:*");
        gender.setFont(new Font("Osward", Font.BOLD, 20));
        gender.setBounds(200, 260, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(400, 260, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(500, 260, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel emailAddress = new JLabel("Email Address:*");
        emailAddress.setFont(new Font("Osward", Font.BOLD, 20));
        emailAddress.setBounds(200, 300, 200, 30);
        add(emailAddress);
        
        emailAddressTextField = new JTextField();
        emailAddressTextField.setBounds(400, 300, 250, 30);
        add(emailAddressTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Osward", Font.BOLD, 20));
        maritalStatus.setBounds(200, 340, 200, 30);
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(400, 340, 70, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(470, 340, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        divorced = new JRadioButton("Divorced");
        divorced.setBounds(560, 340, 90, 30);
        divorced.setBackground(Color.WHITE);
        add(divorced);
        
        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);
        
        JLabel address = new JLabel("Address:*");
        address.setFont(new Font("Osward", Font.BOLD, 20));
        address.setBounds(200, 380, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setBounds(400, 380, 250, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:*");
        city.setFont(new Font("Osward", Font.BOLD, 20));
        city.setBounds(200, 420, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setBounds(400, 420, 250, 30);
        add(cityTextField);
        
        JLabel pinCode = new JLabel("Pin Code:*");
        pinCode.setFont(new Font("Osward", Font.BOLD, 20));
        pinCode.setBounds(200, 460, 200, 30);
        add(pinCode);
        
        pinCodeTextField = new JTextField();
        pinCodeTextField.setBounds(400, 460, 250, 30);
        add(pinCodeTextField);
        
        JLabel state = new JLabel("State:*");
        state.setFont(new Font("Osward", Font.BOLD, 20));
        state.setBounds(200, 500, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setBounds(400, 500, 250, 30);
        add(stateTextField);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(400, 570, 100, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        next = new JButton("Next");
        next.setBounds(550, 570, 100, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
     
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setLocation(150,0);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource() == next){
            setVisible(false);
            String formno = "" + number; //long convert to string
            new SignUp2(formno).setVisible(true);
            String name = nameTextField.getText();
            String fname = fatherNameTextField.getText();
            String dob = ((JTextField) dateOfBirthTextField.getDateEditor().getUiComponent()).getText();
            //String dob = dateOfBirthTextField.getDateFormatString();
            
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if(female.isSelected()){
                gender = "Female";
            }
            
            String email = emailAddressTextField.getText();
            
            String marital = null;
            if(married.isSelected()){
                marital = "Married";
            }
            else if(unmarried.isSelected()){
                marital = "Unmarried";
            }
            else if(divorced.isSelected()){
                marital = "Divorced";
            }
            
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String pincode = pinCodeTextField.getText();
            String state = stateTextField.getText();
            
            try{
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is Required");
                }
                else{
                    JDBCConnection c = new JDBCConnection(); //Create object of class JDBCConnection
                    //Execute Query
                    String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                    c.stmt.executeUpdate(query);
                }
//                else if(fname.equals("")){
//                    JOptionPane.showMessageDialog(null, "Father's name is Required");
//                }
//                else if(dob.equals(null)){
//                    JOptionPane.showMessageDialog(null, "Date of birth is Required");
//                }
//                else if(gender.equals("")){
//                    JOptionPane.showMessageDialog(null, "Gender is Required");
//                }
//                else if(email.equals("")){
//                    JOptionPane.showMessageDialog(null, "Email is Required");
//                }
//                else if(address.equals("")){
//                    JOptionPane.showMessageDialog(null, "Address is Required");
//                }
//                else if(city.equals("")){
//                    JOptionPane.showMessageDialog(null, "City is Required");
//                }
//                else if(pincode.equals("")){
//                    JOptionPane.showMessageDialog(null, "Pincode is Required");
//                }
//                else if(state.equals("")){
//                    JOptionPane.showMessageDialog(null, "State is Required");
//                }  
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new SignUp("");
    }
    
}