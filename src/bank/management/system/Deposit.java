
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java .util.*;


public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(850,770, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,850,750);
         add(image);
         
         JLabel text = new JLabel("Enter the amount you want to Deposit");
         text.setBounds(170 ,230,700,100);
         text.setFont(new Font("System",Font.BOLD,16));
         text.setForeground(Color.WHITE);
         image.add(text);
         
         amount = new JTextField();
         amount.setBounds(170 ,300,300,30);
         amount.setFont(new Font("Raleway",Font.BOLD,18));
         image.add(amount);
         
         deposit = new JButton("DEPOSIT");
         deposit.setBounds(340,410,150 ,25);
         deposit.addActionListener(this);
         image.add(deposit);
         
         back = new JButton("Back");
         back.setBounds(340,440,150 ,25);
         back.addActionListener(this);
         image.add(back);
        
        setSize(850,700);
        setLocation(250,0);
        setVisible(true);
    }

   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount ypu want to deposit");
            }else{
                try{
                Conn c = new Conn();
                String query ="insert into bank values('"+ pinnumber +"','"+ date +"','deposit','"+ number +"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS "+number+" Deposited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                System.out.println(e);
                }
            
            }
        
        }else if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Deposit("");
    }

}
