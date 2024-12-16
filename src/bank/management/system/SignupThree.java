
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java .util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    
    
    SignupThree(){
        
       setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("raleway", Font.BOLD, 22));
        l1.setBounds(280,20,400,40);
        add(l1);
        
        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("raleway", Font.BOLD, 22));
        accType.setBounds(100,80,200,30);
        add(accType);
        
        r1= new JRadioButton("Saving Account");
        r1.setBounds(100, 120,220, 20);
        r1.setFont(new Font("raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2= new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350, 120, 220, 20);
        r2.setFont(new Font("raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setBounds(100, 160, 220, 20);
        r3.setFont(new Font("raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350, 160, 220, 20);
        r4.setFont(new Font("raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("raleway", Font.BOLD, 22));
        card.setBounds(100,210,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-7352");
        number.setFont(new Font("raleway", Font.BOLD, 22));
        number.setBounds(330,210,300,30);
        add(number);
        
        JLabel carddetail = new JLabel("your 16 digit card no");
        carddetail.setFont(new Font("raleway", Font.BOLD, 12));
        carddetail.setBounds(100,230,300,20);
        add(carddetail);

        
        JLabel pin = new JLabel("Pin Number:");
        pin.setFont(new Font("raleway", Font.BOLD, 22));
        pin.setBounds(100,280,200,30);
        add(pin);
        
        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("raleway", Font.BOLD, 22));
        pinno.setBounds(330,280,200,30);
        add(pinno);
        
        JLabel pindetail = new JLabel("your 4 digit pin");
        pindetail.setFont(new Font("raleway", Font.BOLD, 12));
        pindetail.setBounds(100,310,300,20);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("raleway", Font.BOLD, 22));
        services.setBounds(100,370,200,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,420,200,30);
        add(c1);
        
        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,420,200,30);
        add(c2);
        
        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,470,230,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL/SMS ALERTS");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,470,200,30);
        add(c4);
        
        c5 = new JCheckBox("CHECKBOOK");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,520,200,30);
        add(c5);
        
        c6 = new JCheckBox("E STATEMENT ");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,520,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of  my knowledge ");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,580,600,20);
        add(c7);
        
        
        submit =new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.setBounds(250, 640, 100, 30);
        submit.addActionListener(this);
        add(submit);
        getContentPane().setBackground(Color.WHITE);

        
        cancel =new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.setBounds(420, 640,100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);

        
    setSize(850, 750);
    setLocation(350,0);
    setVisible(true);
    }

   

    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    if(ae.getSource()==submit){
        String accountType = null;
         if(r1.isSelected()){
              accountType ="Saving account";
          }else if(r2.isSelected()){
             accountType ="Fixed deposit account";
          }else if(r3.isSelected()){
             accountType ="Current account";
          }else if(r4.isSelected()){
              accountType ="Recurring account ";
          }
         Random random = new Random();
         
         String cardnumber ="" + Math.abs((random.nextLong()% 90000000L)+8646535000000000L);
         
         String pinnumber =""+ Math.abs((random.nextLong()%9000L)+1000L);
         
         String facility ="";
         if(c1.isSelected()){
             facility = facility + " ATM CARD";
         } else if(c2.isSelected()){
             facility = facility + " INTERNET BANKING";
         } else if (c3.isSelected()){
             facility = facility + " MOBILE BANKING";
         } else if (c4.isSelected()){
             facility = facility +" EMAIL/SMS ALERT";
         } else if (c5 .isSelected()){
             facility = facility +" CHECKBOOK";
         } else if (c6.isSelected()){
             facility = facility +" E STATEMENT";
         }   
        try{
        if(accountType==""){
            JOptionPane.showMessageDialog(null,"account type is required");
        }else{
        Conn c = new Conn();
        String query1 ="insert into signupthree values('"+ accountType +"','"+ cardnumber +"','"+ pinnumber +"','"+ facility +"')"; 
        String query2 ="insert into login values('"+ cardnumber +"','"+ pinnumber +"')"; 
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        }    
        JOptionPane.showMessageDialog(null, "CARD NUMBER: "+cardnumber+"\n PIN: "+pinnumber);
        
        setVisible (false);
        new Deposit(pinnumber).setVisible(true);
      }
     catch(Exception e){
      System.out.println(e);   
     } 
    }else if (ae.getSource()==cancel){
        setVisible(false);
        new Login().setVisible(true);
        

    }else {}   
        }
    public static void main(String args[]) {
        new SignupThree();
    }
}
