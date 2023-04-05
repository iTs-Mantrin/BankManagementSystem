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
public class FastCash extends JFrame implements ActionListener{
    
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000,  back; 
    String cardNumber;
    FastCash(String cardNumber){
        this.cardNumber = cardNumber;
        
        setLayout(null);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/window1.jpg"));
        Image img = image.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //import java.awt.Image;
        ImageIcon convertImg  = new ImageIcon(img);
        JLabel imageLabel = new JLabel(convertImg);
        imageLabel.setBounds(0,0,900,700);
        add(imageLabel);
        
        JLabel instruction = new JLabel("SELECt WITHDRWAL AMOUNT");
        instruction.setFont(new Font("Osward", Font.BOLD, 40));
        instruction.setForeground(Color.WHITE);
        instruction.setBounds(120, 80, 700,50);
        imageLabel.add(instruction);
        
        rs100 = new JButton("Rs 100");
        rs100.setFont(new Font("Osward", Font.BOLD, 35));
        rs100.setForeground(Color.WHITE);
        rs100.setBackground(Color.BLUE);
        rs100.addActionListener(this);
        rs100.setBounds(50, 200, 300,50);
        imageLabel.add(rs100);
        
        rs500 = new JButton("Rs 500");
        rs500.setFont(new Font("Osward", Font.BOLD, 35));
        rs500.addActionListener(this);
        rs500.setForeground(Color.WHITE);
        rs500.setBackground(Color.BLUE);
        rs500.setBounds(550, 200, 300,50);
        imageLabel.add(rs500);
        
        rs1000 = new JButton("Rs 1000");
        rs1000.setFont(new Font("Osward", Font.BOLD, 35));
        rs1000.addActionListener(this);
        rs1000.setForeground(Color.WHITE);
        rs1000.setBackground(Color.BLUE);
        rs1000.setBounds(50, 300, 300,50);
        imageLabel.add(rs1000);
        
        rs2000 = new JButton("Rs 2000");
        rs2000.setFont(new Font("Osward", Font.BOLD, 35));
        rs2000.addActionListener(this);
        rs2000.setForeground(Color.WHITE);
        rs2000.setBackground(Color.BLUE);
        rs2000.setBounds(550, 300, 300,50);
        imageLabel.add(rs2000);
        
        rs5000 = new JButton("Rs 5000");
        rs5000.setFont(new Font("Osward", Font.BOLD, 35));
        rs5000.addActionListener(this);
        rs5000.setForeground(Color.WHITE);
        rs5000.setBackground(Color.BLUE);
        rs5000.setBounds(50, 400, 300,50);
        imageLabel.add(rs5000);
        
        rs10000 = new JButton("Rs 10000");
        rs10000.setFont(new Font("Osward", Font.BOLD, 30));
        rs10000.addActionListener(this);
        rs10000.setForeground(Color.WHITE);
        rs10000.setBackground(Color.BLUE);
        rs10000.setBounds(550, 400, 300,50);
        imageLabel.add(rs10000);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 35));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        back.setBounds(550, 500, 300,50);
        imageLabel.add(back);
        
        
        
        
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
      else{
          try{
              String amt = ((JButton)ae.getSource()).getText().substring(3);
          Date date = new Date();
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
          if((JButton)ae.getSource()!=back && balance < Integer.parseInt(amt)){
              JOptionPane.showMessageDialog(null,"Insufficient balance");
          }
          else{
              
              String query = "INSERT INTO bankTransactions VALUES('"+cardNumber+"','"+date+"','debit','"+amt+"')";
              c.stmt.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+ amt +" debited successfully");
              setVisible(false);
              new Transactions(cardNumber).setVisible(true);
            }
          }
          catch(Exception e){
              System.out.println(e);
          }
      }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
     public static void main(String args[]){
        new FastCash("");
    }   
    
}
