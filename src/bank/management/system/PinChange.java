
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java .util.*;
import java .sql.*;


public class PinChange extends JFrame implements ActionListener{
      JPasswordField pin,repin;
      JButton change,back;
      String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(850,770, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,850,750);
         add(image);
         
         JLabel text = new JLabel("CHANGE YOUR PIN");
         text.setBounds(220 ,200,700,100);
         text.setFont(new Font("raleway",Font.BOLD,20));
         text.setForeground(Color.WHITE);
         image.add(text);
         
         JLabel pintext = new JLabel("New PIN:");
         pintext.setBounds(150 ,270,100,35);
         pintext.setFont(new Font("raleway",Font.BOLD,20));
         pintext.setForeground(Color.WHITE);
         image.add(pintext);
         
         
         pin = new JPasswordField();
         pin.setFont(new Font("Raleway",Font.BOLD,20));
         pin.setBounds(340 ,280,150,20);
         image.add(pin);
         
         JLabel repintext = new JLabel("Re-enter New PIN:");
         repintext.setBounds(150 ,320,200,35);
         repintext.setFont(new Font("raleway",Font.BOLD,20));
         repintext.setForeground(Color.WHITE);
         image.add(repintext);
         
         repin = new JPasswordField();
         repin.setFont(new Font("Raleway",Font.BOLD,18));
         repin.setBounds(340 ,330,150,20);
         image.add(repin);
         
         change = new JButton("CHANGE");
         change.setBounds(340,410,150 ,25);
         change.addActionListener(this);
         image.add(change);
         
         back  = new JButton("BACK");
         back.setBounds(340,440,150 ,25);
         back.addActionListener(this);
         image.add(back);
         
        setSize(850,700);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
    }
    
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == change){
        try{
        String npin = pin.getText();
        String rpin = repin.getText();
        
            if(!npin.equals(rpin)){
              JOptionPane.showMessageDialog(null, "Entered pin does not match");
              return;
           }
               if(npin.equals("")){
              JOptionPane.showMessageDialog(null, "Please enter Pin");
              return;
          }
             if(rpin.equals("")){
              JOptionPane.showMessageDialog(null, "Please re-enter new pin");
              return;
        }

         
        
        Conn c= new Conn();
        String query1 ="update bank set pin ='"+rpin+"'where pin ='"+pinnumber+"'"; 
        String query2 ="update login set pin ='"+rpin+"'where pin ='"+pinnumber+"'";
        String query3 ="update signupthree set pin ='"+rpin+"'where pin ='"+pinnumber+"'";
        
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        c.s.executeUpdate(query3);
        
     JOptionPane.showMessageDialog(null, "Pin changed successfully");
        
        setVisible(false);
        new Transaction(rpin).setVisible(true);
        
    }catch(Exception e){
    System.out.println(e);
    }

    }else{
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
        
    }
  
    
    
}
