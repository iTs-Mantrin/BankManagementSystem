package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/*
 * @author Manish Kumar
 */
public class SignUp3 extends JFrame implements ActionListener{
    
    JButton back, submit, cancel;
    JRadioButton savingAccount, fixedDepositAccount, currentAccount, recurringDepositAccount;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement, declaration;
    String formno;
    SignUp3(String formno){
        this.formno =formno;
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Osward", Font.BOLD, 22));
        accountDetails.setBounds(290, 90, 300, 30);
        add(accountDetails);
        
        
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Osward", Font.BOLD, 15));
        accountType.setBounds(200, 150, 150, 30);
        add(accountType);
        
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBounds(200, 180, 150, 20);
        savingAccount.setBackground(Color.WHITE);
        add(savingAccount);
        
        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBounds(400, 180, 200, 20);
        fixedDepositAccount.setBackground(Color.WHITE);
        add(fixedDepositAccount);
        
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setBounds(200, 200, 150, 20);
        currentAccount.setBackground(Color.WHITE);
        add(currentAccount);
        
        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setBounds(400, 200, 200, 20);
        recurringDepositAccount.setBackground(Color.WHITE);
        add(recurringDepositAccount);
        
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingAccount);
        accountTypeGroup.add(fixedDepositAccount);
        accountTypeGroup.add(currentAccount);
        accountTypeGroup.add(recurringDepositAccount);
        
        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Osward", Font.BOLD, 15));
        cardNumber.setBounds(200, 250, 150, 30);
        add(cardNumber);
        
        JLabel description1 = new JLabel("(Your 16-digit card number)");
        description1.setFont(new Font("Osward", Font.BOLD, 10));
        description1.setBounds(200, 270, 150, 30);
        add(description1);
        
        JLabel cardNumbers = new JLabel("XXXX-XXXX-XXXX-8546");
        cardNumbers.setFont(new Font("Osward", Font.BOLD, 15));
        cardNumbers.setBounds(400, 250, 200, 30);
        add(cardNumbers);
        
        JLabel description2 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        description2.setFont(new Font("Osward", Font.BOLD, 10));
        description2.setBounds(400, 270, 300, 30);
        add(description2);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 15));
        pin.setBounds(200, 320, 50, 30);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Osward", Font.BOLD, 15));
        pinNumber.setBounds(400, 320, 150, 30);
        add(pinNumber);
                
        JLabel description3 = new JLabel("(4-digit password)");
        description3.setFont(new Font("Osward", Font.BOLD, 10));
        description3.setBounds(200, 340, 150, 30);
        add(description3);
        
        JLabel serviceRequired = new JLabel("Service Required:");
        serviceRequired.setFont(new Font("Osward", Font.BOLD, 15));
        serviceRequired.setBounds(200, 390, 150, 30);
        add(serviceRequired);
        
        atmCard = new JCheckBox("ATM Card");
        atmCard.setBackground(Color.WHITE);
        atmCard.setBounds(200, 420, 150, 30);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(400, 420, 150, 30);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(200, 450, 150, 30);
        add(mobileBanking);
        
        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setBackground(Color.WHITE);
        emailAlerts.setBounds(400, 450, 150, 30);
        add(emailAlerts);
        
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(200, 480, 150, 30); 
        add(chequeBook);
        
        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(400, 480, 150, 30);
        add(eStatement);
        
        declaration = new JCheckBox("I hereby declares that the above entered details correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Osward", Font.BOLD, 10));
        declaration.setBounds(200, 530, 500, 20);
        add(declaration);
       
        
        back = new JButton("Back");
        back.setBounds(200, 570, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBounds(350, 570, 100, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(500, 570, 100, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
     
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setLocation(150,0);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new SignUp2(formno).setVisible(true);
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        else if(ae.getSource() == submit){   
            String account = "";
            if(savingAccount.isSelected()){
                account = "Saving Account";
            }
            else if(fixedDepositAccount.isSelected()){
                account = "Fixed Deposit Account";
            }else if(currentAccount.isSelected()){
                account = "Current Account";
            }else if(recurringDepositAccount.isSelected()){
                account = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardNo = "" + Math.abs((random.nextLong() % 90000000L) + 6080433400000000L);
            //String card = ""+cardNo.substring(0,4) + " " +cardNo.substring(4,4)+ " " +cardNo.substring(8,4)+ " " + cardNo.substring(12,16);
            String pinno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String atm = "false";
            if(atmCard.isSelected()){
                atm = "true";
            }
            
            String mBanking = "false";
            if(mobileBanking.isSelected()){
                mBanking = "true";
            }
            
            String iBanking = "false";
            if(internetBanking.isSelected()){
                iBanking = "true";
            }
            
            String eAlerts = "false";
            if(emailAlerts.isSelected()){
                eAlerts = "true";
            }
            
            String cheque = "false";
            if(chequeBook.isSelected()){
                cheque = "true";
            }
            
            String Statement = "false";
            if(eStatement.isSelected()){
                Statement = "true";
            }
            
            String declare = "false";
            if(declaration.isSelected()){
                declare = "true";
            }
                       
            try{
                
                if(account.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                    
                }
                else{
                    JDBCConnection c = new JDBCConnection(); //Create object of class JDBCConnection
                    //Execute Query
                    String query = "INSERT INTO signup3 VALUES('"+formno+"','"+account+"','"+atm+"','"+mBanking+"','"+iBanking+"','"+eAlerts+"','"+cheque+"','"+Statement+"','"+declare+"')";
                    String query2 = "INSERT INTO login VALUES('"+formno+"','"+cardNo+"','"+pinno+"')";
                    c.stmt.executeUpdate(query);
                    c.stmt.executeUpdate(query2);
 
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNo + "\nPin: " + pinno);
                }  
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    
    public static void main(String args[]){
        new SignUp3("");
    }
}