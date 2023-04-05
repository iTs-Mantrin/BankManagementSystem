package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * @author Manish Kumar
 */
public class SignUp2 extends JFrame implements ActionListener{
    
    JTextField  panNumberTextField, aadharNumberTextField;
    JRadioButton seniorYes, seniorNo,existingAccountYes, existingAccountNo;
    JComboBox religionComboBox, categoryNameComboBox, incomeComboBox, educationQualificationComboBox, occupationComboBox;
    JButton next, back;
    String formno;
    SignUp2(String formno){
        this.formno =formno;
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Osward", Font.BOLD, 22));
        additionalDetails.setBounds(290, 90, 300, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Osward", Font.BOLD, 20));
        religion.setBounds(200, 140, 200, 30);
        add(religion);
        
        String religionArr[] = {"Hindu","Muslim","Christian","Sikh","Buddhist","Jain","Other"};
        religionComboBox = new JComboBox(religionArr);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setBounds(400, 140, 250, 30);
        add(religionComboBox);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Osward", Font.BOLD, 20));
        category.setBounds(200, 180, 200, 30);
        add(category);
        
        String categoryArr[] = {"General","OBC","SC","ST"};
        categoryNameComboBox = new JComboBox(categoryArr);
        categoryNameComboBox.setBackground(Color.WHITE);
        categoryNameComboBox.setBounds(400, 180, 250, 30);
        add(categoryNameComboBox);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Osward", Font.BOLD, 20));
        income.setBounds(200, 220, 200, 30);
        add(income);
        
        String incomeArr[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomeComboBox = new JComboBox(incomeArr);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setBounds(400, 220, 250, 30);
        add(incomeComboBox);
        
        JLabel educationQualification = new JLabel("Education Qualification:");
        educationQualification.setFont(new Font("Osward", Font.BOLD, 20));
        educationQualification.setBounds(200, 260, 230, 30);
        add(educationQualification);
        
        String educationArr[] = {"Illitrate","High School","Graduate","Under Graduate","Post Graduate","Doctrate","Other"};
        educationQualificationComboBox = new JComboBox(educationArr);
        educationQualificationComboBox.setBounds(450, 260, 200, 30);
        educationQualificationComboBox.setBackground(Color.WHITE);
        add(educationQualificationComboBox);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Osward", Font.BOLD, 20));
        occupation.setBounds(200, 300, 200, 30);
        add(occupation);
        
        String occupationArr[] = {"Salaried","Self Employed","Business","Student","Retired","Other"};
        occupationComboBox = new JComboBox(occupationArr);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setBounds(400, 300, 250, 30);
        add(occupationComboBox);
        
        JLabel panNumber = new JLabel("Pan Number:");
        panNumber.setFont(new Font("Osward", Font.BOLD, 20));
        panNumber.setBounds(200, 340, 200, 30);
        add(panNumber);
        
        panNumberTextField = new JTextField();
        panNumberTextField.setBounds(400, 340, 250, 30);
        add(panNumberTextField);
        
        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Osward", Font.BOLD, 20));
        aadharNumber.setBounds(200, 380, 200, 30);
        add(aadharNumber);
        
        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setBounds(400, 380, 250, 30);
        add(aadharNumberTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Osward", Font.BOLD, 20));
        seniorCitizen.setBounds(200, 420, 200, 30);
        add(seniorCitizen);
        
        seniorYes = new JRadioButton("YES");
        seniorYes.setBounds(400, 420, 70, 30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);
        
        seniorNo = new JRadioButton("NO");
        seniorNo.setBounds(470, 420, 90, 30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorYes);
        seniorCitizenGroup.add(seniorNo);
        
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Osward", Font.BOLD, 20));
        existingAccount.setBounds(200, 460, 200, 30);
        add(existingAccount);
        
        existingAccountYes = new JRadioButton("YES");
        existingAccountYes.setBounds(400, 460, 70, 30);
        existingAccountYes.setBackground(Color.WHITE);
        add(existingAccountYes);
        
        existingAccountNo = new JRadioButton("NO");
        existingAccountNo.setBounds(470, 460, 90, 30);
        existingAccountNo.setBackground(Color.WHITE);
        add(existingAccountNo);
        
        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingAccountYes);
        existingAccountGroup.add(existingAccountNo);
        
        back = new JButton("Back");
        back.setBounds(400, 570, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        next = new JButton("Next");
        next.setBounds(550, 570, 100, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
     
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(900,700);
        setLayout(null);
        setVisible(true);
        setLocation(150,0);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new SignUp(formno).setVisible(true);
        }
        else if(ae.getSource() == next){
            setVisible(false);
            new SignUp3(formno).setVisible(true);
            String religion = (String) religionComboBox.getSelectedItem(); //getSelectedItem return objest so, convert to string using (String)
            String category = (String) categoryNameComboBox.getSelectedItem();
            String income = (String) incomeComboBox.getSelectedItem();
            String educationQualification = (String) educationQualificationComboBox.getSelectedItem();
            String occupation = (String) occupationComboBox.getSelectedItem();
            String panNumber = panNumberTextField.getText();
            String aadharNumber = aadharNumberTextField.getText();            
            String seniorCitizen = null;
            if(seniorYes.isSelected()){
                seniorCitizen = "Yes";
            }
            else if(seniorYes.isSelected()){
                seniorCitizen = "No";
            }
            String existingAccount = null;
            if(existingAccountYes.isSelected()){
                existingAccount = "Yes";
            }
            else if(existingAccountNo.isSelected()){
                existingAccount = "No";
            }
            
            
            try{
                if(religion.equals("")){
                    JOptionPane.showMessageDialog(null, "Religion is Required");
                }
                else{
                    JDBCConnection c = new JDBCConnection(); //Create object of class JDBCConnection
                    //Execute Query
                    String query = "INSERT INTO signup2 VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+educationQualification+"','"+occupation+"','"+panNumber+"','"+aadharNumber+"','"+seniorCitizen+"','"+existingAccount+"')";
                    c.stmt.executeUpdate(query);
                } 
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new SignUp2("");
    }
    
}