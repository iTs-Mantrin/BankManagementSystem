package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import java.util.Date;
import java.sql.*;
/*
 * @author Manish Kumar
 */
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back; 
    String cardNumber;
    JLabel balanceEnquiry;
    BalanceEnquiry(String cardNumber){
        this.cardNumber = cardNumber;
        
        setLayout(null);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/window1.jpg"));
        Image img = image.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //import java.awt.Image;
        ImageIcon convertImg  = new ImageIcon(img);
        JLabel imageLabel = new JLabel(convertImg);
        imageLabel.setBounds(0,0,900,700);
        add(imageLabel);
        
        JLabel instruction = new JLabel("Thank You for using Bank ATM");
        instruction.setFont(new Font("Osward", Font.BOLD, 40));
        instruction.setForeground(Color.WHITE);
        instruction.setBounds(120, 80, 700,50);
        imageLabel.add(instruction);
        
        balanceEnquiry = new JLabel();
        balanceEnquiry.setFont(new Font("Osward", Font.BOLD, 30));
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.setBounds(200, 250, 700,50);
        imageLabel.add(balanceEnquiry);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 35));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        back.setBounds(550, 500, 300,50);
        imageLabel.add(back);
        
        try{
          JDBCConnection c = new JDBCConnection();
          ResultSet rs = c.stmt.executeQuery("SELECT* FROM bankTransactions WHERE cardNumber='"+cardNumber+"'");
          int balance = 0;
          while(rs.next()){
              if(rs.getString("txnType").equals("credit")){
                  balance += Integer.parseInt(rs.getString("amount"));
              } 
              else{
                  balance -= Integer.parseInt(rs.getString("amount"));
              }
            }
            balanceEnquiry.setText("Your current balance Rs. "+balance);
          }
          catch(Exception e){
              System.out.println(e);
          }
        
        
        
        
        //getContentPane().setBackground(Color.WHITE);
        setTitle("Fast Cash Page");
        setSize(900,700);
        setVisible(true);
        setLocation(150,0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {  
      if(ae.getSource()== back){
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }
    
    
     public static void main(String args[]){
        new BalanceEnquiry("");
    }   
    
}
