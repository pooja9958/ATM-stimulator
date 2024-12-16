
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;
 

public class SignupTwo extends JFrame implements ActionListener{
    
    long random;
    JTextField adhar,pan;
    JButton next;
    JRadioButton sno,syes,eyes,eno;
    JComboBox religion,category,income,qualification,occupation;
    
   SignupTwo(){
       
       setLayout(null);
       
       setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 2");
        
        JLabel additionalDetails = new JLabel("page 2:Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[]={"HINDU","MUSLIM","SIKH","CHRISTIAN","OTHERS"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[]={"GENERAL","OBC","SC","ST","OTHERS"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob= new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valIncome[]={"NULL","<1,50,000","<2,50,000","<3,50,000","<5,00,000","OTHERS"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender= new JLabel("Educationl:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        
        JLabel email= new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String valQualification[]={"Non Graduation","Graduation","Post Graduation","doctrate","OTHERS"};
        qualification = new JComboBox(valQualification);
        qualification.setBounds(300, 315, 400, 30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
        
        JLabel marital= new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String valOccupation[]={"Salaried","Non Salaried","Bussiness","Student","Retired","OTHERS"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address= new JLabel("Pan no.:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font ("Raleway",Font.BOLD,20));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        
        JLabel city= new JLabel("Aadhar no.:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        adhar = new JTextField();
        adhar.setFont(new Font ("Raleway",Font.BOLD,20));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);
        
        JLabel seniorcitizen= new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100, 540, 200, 30);
        add(seniorcitizen);
        
        syes = new JRadioButton("yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("no");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
        
      
        
        JLabel existing= new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        
        eyes = new JRadioButton("yes");
        eyes.setBounds(300, 590,100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("no");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);
        
        
        
        
        
        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
       
   setSize(850, 800);
   setLocation(350,0);
   setVisible(true);
   
   
   
   
   }
   public void actionPerformed(ActionEvent ae){
       
      String sreligion =(String)religion.getSelectedItem() ;
      String scategory =(String)category.getSelectedItem() ;
      String sincome =(String)income.getSelectedItem() ;
      String squalification =(String)qualification.getSelectedItem() ;
      String soccupation =(String)occupation.getSelectedItem() ;
      String seniorcitizen = null;
      if(syes.isSelected()){
          seniorcitizen ="yes";
      }else if(sno.isSelected()){
          seniorcitizen ="no";
      
      }
      
      String existing = null;
      if(eyes.isSelected()){
          existing ="yes";
      }else if(eno.isSelected()){
          existing ="no";
      
      }
      String span = pan.getText();
      String sadhar = adhar.getText();
      
      try{
         if(span==""){
            JOptionPane.showMessageDialog(null,"Pan is required");
        }else if(sadhar==""){
            JOptionPane.showMessageDialog(null,"Adhar is required");
        }else{
        Conn c = new Conn();
        String query ="insert into signuptwo values('"+ sreligion +"','"+ scategory +"','"+ sincome +"','"+ squalification +"','"+ soccupation +"','"+ span +"','"+ sadhar +"','"+ seniorcitizen+"','"+ existing +"')"; 
        c.s.executeUpdate(query);
        
         }
      }
     catch(Exception e){
      System.out.println(e);   
     } 
     setVisible(false);
     new SignupThree().setVisible(true);
      
   }
    
    public static void main(String args[]){
    new SignupTwo();
    }
    
}



    

