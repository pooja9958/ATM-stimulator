
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement  extends JFrame{
    String pinnumber;
    
    MiniStatement(String pinnumber){
        setTitle("Mini statement ");
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        JLabel mini = new JLabel();
        add(mini);
        
        
        JLabel text = new JLabel("MUIT Bank");
         text.setBounds(110 ,30,100,20);
         add(text);
         
          JLabel card = new JLabel();
          card.setBounds(20 ,80,300,20);
          add(card);
         
         JLabel balance = new JLabel();
         balance.setBounds(20,400,300,20);
         add(balance);
        
         
         try{
           Conn c = new Conn();
           ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
           while(rs.next()){
             card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
         }
         }catch(Exception e){
             System.out.println(e);
         }
         try{
           Conn c = new Conn();
           int bal =0;
           ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           while(rs.next()){
             mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                     bal +=Integer.parseInt(rs.getString("amount"));
                 }else{

                    bal -=Integer.parseInt(rs.getString("amount"));
                 }
                  }
                 balance.setText("Your current account balance is Rs:"+bal);
         }catch(Exception e){
             System.out.println(e);
         }
        mini.setBounds(20,140,400,200);
         
         
        setSize(400,600);
        setLocation(20,30);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);

    }

    
    public static void main(String args[]) {
       new MiniStatement("");
    }
}
