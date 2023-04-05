package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
/*
 * @author Manish Kumar
 */
public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, cashWithdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, other, exit; 
    String cardNumber;
    Transactions(String cardNumber){
        this.cardNumber = cardNumber;
        
        setLayout(null);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/window1.jpg"));
        Image img = image.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //import java.awt.Image;
        ImageIcon convertImg  = new ImageIcon(img);
        JLabel imageLabel = new JLabel(convertImg);
        imageLabel.setBounds(0,0,900,700);
        add(imageLabel);
        
        JLabel instruction = new JLabel("Please select your Transaction");
        instruction.setFont(new Font("Osward", Font.BOLD, 40));
        instruction.setForeground(Color.WHITE);
        instruction.setBounds(120, 80, 700,50);
        imageLabel.add(instruction);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Osward", Font.BOLD, 35));
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(Color.BLUE);
        deposit.addActionListener(this);
        deposit.setBounds(50, 200, 300,50);
        imageLabel.add(deposit);
        
        cashWithdrawl = new JButton("Cash Withdrawl");
        cashWithdrawl.setFont(new Font("Osward", Font.BOLD, 35));
        cashWithdrawl.addActionListener(this);
        cashWithdrawl.setForeground(Color.WHITE);
        cashWithdrawl.setBackground(Color.BLUE);
        cashWithdrawl.setBounds(550, 200, 300,50);
        imageLabel.add(cashWithdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setFont(new Font("Osward", Font.BOLD, 35));
        fastCash.addActionListener(this);
        fastCash.setForeground(Color.WHITE);
        fastCash.setBackground(Color.BLUE);
        fastCash.setBounds(50, 300, 300,50);
        imageLabel.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setFont(new Font("Osward", Font.BOLD, 35));
        miniStatement.addActionListener(this);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.setBackground(Color.BLUE);
        miniStatement.setBounds(550, 300, 300,50);
        imageLabel.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setFont(new Font("Osward", Font.BOLD, 35));
        pinChange.addActionListener(this);
        pinChange.setForeground(Color.WHITE);
        pinChange.setBackground(Color.BLUE);
        pinChange.setBounds(50, 400, 300,50);
        imageLabel.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setFont(new Font("Osward", Font.BOLD, 30));
        balanceEnquiry.addActionListener(this);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.setBackground(Color.BLUE);
        balanceEnquiry.setBounds(550, 400, 300,50);
        imageLabel.add(balanceEnquiry);
        
        other = new JButton("Other");
        other.setFont(new Font("Osward", Font.BOLD, 35));
        other.addActionListener(this);
        other.setForeground(Color.WHITE);
        other.setBackground(Color.BLUE);
        other.setBounds(50, 500, 300,50);
        imageLabel.add(other);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("Osward", Font.BOLD, 35));
        exit.addActionListener(this);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLUE);
        exit.setBounds(550, 500, 300,50);
        imageLabel.add(exit);
        
        
        
        
        //getContentPane().setBackground(Color.WHITE);
        setTitle("Transaction Page");
        setSize(900,700);
        setVisible(true);
        setLocation(150,0);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== deposit){
            setVisible(false);
            new Deposit(cardNumber).setVisible(true);
        }
        else if(ae.getSource()== cashWithdrawl){
            setVisible(false);
            new Withdrawl(cardNumber).setVisible(true);
        }
        else if(ae.getSource()== fastCash){
            setVisible(false);
            new FastCash(cardNumber).setVisible(true);
            
        } 
        else if(ae.getSource()== miniStatement){
            new MiniStatements(cardNumber).setVisible(true);
            
        }
        else if(ae.getSource()== pinChange){
            setVisible(false);
            new PinChange(cardNumber).setVisible(true);
            
        }
        else if(ae.getSource()== balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(cardNumber).setVisible(true);
        }
        else if(ae.getSource()== other){
            JOptionPane.showMessageDialog(null, "Working on this ");
        }
        else if(ae.getSource()== exit){
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
     public static void main(String args[]){
        new Transactions("");
    }   
    
}
