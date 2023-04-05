package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.sql.*;
/*
 * @author Manish Kumar
 */
public class PinChange extends JFrame implements ActionListener{
    
    JButton change, back; 
    String cardNumber;
    JPasswordField newPintf,confirmNewPintf;
    PinChange(String cardNumber){
        this.cardNumber = cardNumber;
        
        
        setLayout(null);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/window1.jpg"));
        Image img = image.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //import java.awt.Image;
        ImageIcon convertImg  = new ImageIcon(img);
        JLabel imageLabel = new JLabel(convertImg);
        imageLabel.setBounds(0,0,900,700);
        add(imageLabel);
        
        JLabel instruction = new JLabel("Change Your PIN");
        instruction.setFont(new Font("Osward", Font.BOLD, 40));
        instruction.setForeground(Color.WHITE);
        instruction.setBounds(250, 80, 700,50);
        imageLabel.add(instruction);
        
        JLabel newPin = new JLabel("New Pin:");
        newPin.setFont(new Font("Osward", Font.BOLD, 30));
        newPin.setForeground(Color.WHITE);
        newPin.setBounds(100, 200, 300,50);
        imageLabel.add(newPin);
        
        newPintf = new JPasswordField();
        newPintf.setFont(new Font("Osward", Font.BOLD, 30));
        newPintf.setForeground(Color.BLACK);
        newPintf.setBounds(450, 200, 150,40);
        imageLabel.add(newPintf);
        
        
        
        JLabel confirmNewPin = new JLabel("Re-Enter New Pin:");
        confirmNewPin.setFont(new Font("Osward", Font.BOLD, 30));
        confirmNewPin.setForeground(Color.WHITE);
        confirmNewPin.setBounds(100, 250, 300,50);
        imageLabel.add(confirmNewPin);
        
        confirmNewPintf = new JPasswordField();
        confirmNewPintf.setFont(new Font("Osward", Font.BOLD, 30));
        confirmNewPintf.setForeground(Color.BLACK);
        confirmNewPintf.setBounds(450, 250, 150,40);
        imageLabel.add(confirmNewPintf);
          
        change = new JButton("Change");
        change.setFont(new Font("Osward", Font.BOLD, 30));
        change.addActionListener(this);
        change.setForeground(Color.WHITE);
        change.setBackground(Color.BLUE);
        change.setBounds(550, 400, 300,50);
        imageLabel.add(change);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 35));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        back.setBounds(550, 500, 300,50);
        imageLabel.add(back);
        
        
        
        
        //getContentPane().setBackground(Color.WHITE);
        setTitle("Pin Chnage Page");
        setSize(900,700);
        setVisible(true);
        setLocation(150,0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String npin = newPintf.getText();
        String rpin = confirmNewPintf.getText();
        
        
        if(ae.getSource()== change){
            try{
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;       
                }
                else if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                    return;           
                }
                else if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered Pin does not matched");
                    return;
                }
                else if(npin.equals(rpin)){
                    JDBCConnection c = new JDBCConnection();
                    String query = "UPDATE login SET pinNo = '"+rpin+"' WHERE cardNumber = '"+cardNumber+"'";                
                    c.stmt.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Pin changed successfully..");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                }
                
                
                
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
     public static void main(String args[]){
        new PinChange("");
    }   
    
}
