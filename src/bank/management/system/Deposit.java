
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/*
 * @author Manish Kumar
 */
public class Deposit extends JFrame implements ActionListener{
    JButton deposit, back;
    JTextField amtDeposit;
    String cardNumber;
    Deposit(String cardNumber){
        this.cardNumber = cardNumber;   
        setLayout(null);
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/ATM Machine.jpg"));
        Image img = image.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);  //import java.awt.Image;
        ImageIcon convertImg  = new ImageIcon(img);
        JLabel imageLabel = new JLabel(convertImg);
        imageLabel.setBounds(0,0,900,700);
        add(imageLabel);
        
        JLabel instruction = new JLabel("Enter the amount you want to deposit");
        instruction.setFont(new Font("Osward", Font.BOLD, 20));
        instruction.setForeground(Color.red);
        instruction.setBounds(190, 220, 390,30);
        imageLabel.add(instruction);
        
        amtDeposit = new JTextField();
        amtDeposit.setFont(new Font("Osward", Font.BOLD, 20));
        amtDeposit.setForeground(Color.BLACK);
        amtDeposit.setBackground(Color.WHITE);
        amtDeposit.setBounds(200, 300, 300,30);
        imageLabel.add(amtDeposit);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Osward", Font.BOLD, 12));
        deposit.addActionListener(this);
        deposit.setForeground(Color.WHITE);
        deposit.setBackground(Color.GRAY);
        deposit.setBounds(400, 365, 140,25);
        imageLabel.add(deposit);
        
        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 14));
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.setBounds(400, 395, 140,25);
        imageLabel.add(back);
        
        setTitle("Deposit Window");
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setLocation(150,0);
    }
    
    public static void main(String args[]){
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String amt = amtDeposit.getText();
            Date date = new Date();
            if(amt.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
               }
            else{
                try{
                    JDBCConnection c  = new JDBCConnection();
                    String query = "INSERT INTO bankTransactions VALUES('"+cardNumber+"','"+date+"','credit','"+amt+"')";
                    c.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amt+" deposit successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                }
                catch(Exception ee){
                   System.out.println(ee);
                }
            }            
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
