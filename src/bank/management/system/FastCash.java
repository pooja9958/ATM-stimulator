
package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;



public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdraw,fastcash,pinchange,ministate,balanceenquiry,exit;
    String pinnumber;
    
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(850,770, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,850,750);
         add(image);
         
         JLabel text = new JLabel("Select Withdrawl amount");
         text.setBounds(170 ,230,700,100);
         text.setFont(new Font("raleway",Font.BOLD,20));
         text.setForeground(Color.WHITE);
         image.add(text);
         
         deposit = new JButton("Rs 100");
         deposit.setBounds(145,350,150 ,25);
         deposit.addActionListener(this);
         image.add(deposit);
         
         withdraw = new JButton("Rs 500");
         withdraw.setBounds(340,350,150 ,25);
         withdraw.addActionListener(this);
         image.add(withdraw);
         
         fastcash = new JButton("Rs 1000");
         fastcash.setBounds(145,380,150 ,25);
         fastcash.addActionListener(this);
         image.add(fastcash);
         
         ministate = new JButton("Rs 2000");
         ministate.setBounds(340,380,150 ,25);
         ministate.addActionListener(this);
         image.add(ministate);
         
         pinchange = new JButton("Rs 5000");
         pinchange.setBounds(145,410,150 ,25);
         pinchange.addActionListener(this);
         image.add(pinchange);
         
         balanceenquiry = new JButton("Rs 10,000");
         balanceenquiry.setBounds(340,410,150 ,25);
         balanceenquiry.addActionListener(this);
         image.add(balanceenquiry);
         
         exit  = new JButton("BACK");
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
           setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!=exit && balance > Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }else{
                    Date date = new Date(); 
                    String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                    c.s.executeUpdate(query); 
                    JOptionPane.showMessageDialog(null,"Rs "+amount +" Debited Successfully");
                    
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                }catch(Exception e){
                System.out.println(e);
                }
        }
    }
    public static void main(String args[]) {
       new FastCash("");
    }
}
 
