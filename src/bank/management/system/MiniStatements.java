
package bank.management.system;
import javax.swing.*;
import java.sql.*;
/*
 * @author Manish Kumar
 */
public class MiniStatements extends JFrame{
    String cardNumber;
        JLabel balance;
    MiniStatements(String cardNumber){
        setLayout(null);
        this.cardNumber = cardNumber;
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 500, 300);
        add(mini);
        
        balance = new JLabel();
        balance.setBounds(20, 400, 100,50);
        add(balance);
        
        
        
        JLabel heading = new JLabel("Mini Statements");
        heading.setBounds(150,50,100,20);
        add(heading);
        
        JLabel card = new JLabel("Card Number:");
        card.setBounds(50,100,300,20);
        card.setText("Card Number: "+ cardNumber.substring(0,4) + " XXXX XXXX " + cardNumber.substring(12,16));

        add(card);
        
        try{
            int bal = 0;
            JDBCConnection c = new JDBCConnection();
            String query = "SELECT* FROM bankTransactions WHERE cardNumber = '"+cardNumber+"'"; 
            ResultSet rs = c.stmt.executeQuery(query);
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("txnType") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br></html>");
                 
                if(rs.getString("txnType").equals("credit")){
                  bal += Integer.parseInt(rs.getString("amount"));
                } 
                else{
                  bal-= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs." +bal );
       
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        setTitle("Mini Statements Page");
        setSize(400,600);
        setVisible(true);
        setLocation(150,0);
    }
    public static void main(String args[]){
        new MiniStatements("");
    }
    
}
