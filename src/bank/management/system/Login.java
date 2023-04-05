package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

/*
 * @author Manish Kumar
 */
public class Login extends JFrame implements ActionListener{
    
    JButton signIn, signUp, clear;
    JTextField cardNoTextField;
    JPasswordField pinPasswordField;
    Login(){ 
        //add image
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //resize the image height and width
        Image logoResize = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //can't add image in JLabel, so, convert into ImageIcon
        ImageIcon logoConvert = new ImageIcon(logoResize);
        JLabel iconLogo = new JLabel(logoConvert);
        iconLogo.setBounds(70, 30, 100, 100);
        
        add(iconLogo);
        
        JLabel heading = new JLabel("Welcome to ATM");
        heading.setFont(new Font("Osward", Font.BOLD, 38));
        heading.setBounds(200, 40, 500, 100);
        add(heading);
        
        
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setBounds(150, 150, 150, 30);
        cardNo.setFont(new Font("Osward",Font.BOLD, 28));
        add(cardNo);
        
        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(350, 150, 250, 30);
        add(cardNoTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD, 28));
        pin.setBounds(150, 200, 150, 30);
        add(pin);
        
        pinPasswordField = new JPasswordField();
        pinPasswordField.setBounds(350, 200, 250, 30);
        add(pinPasswordField);
        
        signIn = new JButton("SIGN IN");
        signIn.setBounds(250, 300, 140, 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);
        
        clear = new JButton("CLEAR");
        clear.setBounds(400, 300, 140, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(330, 350, 140, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800,480);
        setVisible(true);
        setLocation(250,100);
    }
    
    
    public static void main(String args[]){
        new Login();    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signIn){
             JDBCConnection cn = new JDBCConnection();
             String cardNumber = cardNoTextField.getText();
             String pinNumber = pinPasswordField.getText();
             String query = "SELECT* FROM login WHERE cardNumber = '"+cardNumber+"' && pinNo = '"+pinNumber+"' ";
             try{
                 ResultSet rs = cn.stmt.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transactions(cardNumber).setVisible(true);
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                 }
             }
             catch(Exception e){
                 System.out.println(e);
             }
         }
         else if (ae.getSource() == clear){
             cardNoTextField.setText("");
             pinPasswordField.setText("");
         }
         else if (ae.getSource() == signUp){
             setVisible(false);
             new SignUp("").setVisible(true);
             
         }
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
