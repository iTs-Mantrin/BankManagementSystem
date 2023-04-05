
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

/*
 * @author Manish Kumar
 */
public class Withdrawl extends JFrame implements ActionListener{
    JButton withdrwal, back;
    JTextField amtWithdrawl;
    String cardNumber;
    Withdrawl(String cardNumber){
        this.cardNumber = cardNumber;
        setLayout(null);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/ATM Machine.jpg"));
        Image img = image.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //import java.awt.Image;
        ImageIcon convertImg  = new ImageIcon(img);
        JLabel imageLabel = new JLabel(convertImg);
        imageLabel.setBounds(0,0,900,700);
        add(imageLabel);
        
        JLabel instruction = new JLabel("Enter the amount you want to Withdraw");
        instruction.setFont(new Font("Osward", Font.BOLD, 20));
        instruction.setForeground(Color.red);
        instruction.setBounds(190, 220, 390,30);
        imageLabel.add(instruction);
        
        amtWithdrawl = new JTextField();
        amtWithdrawl.setFont(new Font("Osward", Font.BOLD, 20));
        amtWithdrawl.setForeground(Color.BLACK);
        amtWithdrawl.setBackground(Color.WHITE);
        amtWithdrawl.setBounds(200, 300, 300,30);
        imageLabel.add(amtWithdrawl);
        
        withdrwal = new JButton("Withdrwal");
        withdrwal.setFont(new Font("Osward", Font.BOLD, 12));
        withdrwal.addActionListener(this);
        withdrwal.setForeground(Color.WHITE);
        withdrwal.setBackground(Color.GRAY);
        withdrwal.setBounds(400, 365, 140,25);
        imageLabel.add(withdrwal);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 14));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.setBounds(400, 395, 140,25);
        imageLabel.add(back);
        
        setTitle("Withdrawl Window");
        setSize(900,700);
        setVisible(true);
        setLocation(150,0);
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdrwal){
               String amt = amtWithdrawl.getText();
               Date date = new Date();
               if(amt.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
               }
               else{
                   try{
                       JDBCConnection c  = new JDBCConnection();
                        String query = "INSERT INTO bankTransactions VALUES('"+cardNumber+"','"+date+"','debit','"+amt+"')";
                        c.stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs "+amt+" withdraw successfully");
                        setVisible(false);
                        new Transactions("").setVisible(true);
                   }
                   catch(Exception ee){
                       System.out.println(ee);
                   }
               }
                
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transactions("").setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
