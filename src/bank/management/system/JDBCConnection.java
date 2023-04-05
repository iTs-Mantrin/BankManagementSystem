
package bank.management.system;

import java.sql.*;

/*
 * @author Manish Kumar
 */
public class JDBCConnection {
    
    Connection con;
    Statement stmt;
    public JDBCConnection(){
        try{
            //Register the Driver
            //Class.forName(com.mysql.cj.jdbc.Driver);
            
            //Create Connection
            con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
            
            //Create Statements
            stmt = con.createStatement();
            
            //Execute Query
//            ***Under SignUp class***
//            JDBCConnection con = new JDBCConnection(); //Create object of class JDBCConnection
//            String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
//            con.stmt.executeUpdate(query);
            
            //Close Connection
        }
        catch(Exception e){
            System.out.println(e);
        }
     
        
    }
    
    
    
}
