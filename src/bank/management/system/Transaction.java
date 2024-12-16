
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java .util.*;



public class Transaction extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastcash,pinchange,ministate,balanceenquiry,exit;
    String pinnumber;
    
    
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(850,770, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,850,750);
         add(image);
         
         JLabel text = new JLabel("Please select your Transaction");
         text.setBounds(170 ,230,700,100);
         text.setFont(new Font("raleway",Font.BOLD,20));
         text.setForeground(Color.WHITE);
         image.add(text);
         
         deposit = new JButton("DEPOSIT");
         deposit.setBounds(145,350,150 ,25);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdraw = new JButton("CASH WITHDRAW");
         withdraw.setBounds(340,350,150 ,25);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         fastcash = new JButton("FAST CASH");
         fastcash.setBounds(145,380,150 ,25);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministate = new JButton("MINI STATEMENT");
         ministate.setBounds(340,380,150 ,25);
         ministate.addActionListener(this);
         image.add(ministate);
         
         pinchange = new JButton("PIN CHANGE");
         pinchange.setBounds(145,410,150 ,25);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balanceenquiry = new JButton("BALANCE ENQUIRY");
         balanceenquiry.setBounds(340,410,150 ,25);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         exit  = new JButton("EXIT");
         exit.setBounds(340,440,150 ,25);
         exit.addActionListener(this);
         image.add(exit);
        
         
        setSize(850,700);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
                
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
        System.exit(0);
        }else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()== withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if (ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource()== balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()== ministate){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
       new Transaction("");
    }
}
 