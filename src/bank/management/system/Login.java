 package bank.management.system;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 public class Login extends JFrame implements ActionListener {
     
    JButton login,signup,clear; 
    JTextField cardTextField;
    JPasswordField passwordTextField;
    String pinnumber;
    
    Login(){
        this.pinnumber =pinnumber;
        setTitle("Automated Teller Machine");
         setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
         Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel label = new JLabel(i3);
         label.setBounds(70, 10, 100, 100);
         add(label);
         
        
         JLabel text = new JLabel("Welcome to ATM");
         text.setFont(new Font("Osward",Font.BOLD,38));
         text.setBounds(200, 40, 400, 40);
         add(text);
         
         JLabel cardnumber = new JLabel("card number");
         cardnumber.setFont(new Font("Raleway",Font.BOLD,20));
         cardnumber.setBounds(120, 150, 150, 30);
         add(cardnumber);
         
         
          cardTextField = new JTextField();
         cardTextField.setBounds(300, 150, 230, 30);
         cardTextField.setFont(new Font("Arial",Font.BOLD,14));
         add(cardTextField);
         
         JLabel password = new JLabel("password");
         password.setFont(new Font("Raleway",Font.BOLD,20));
         password.setBounds(120, 200, 150, 30);
         add(password);
         
         passwordTextField =  new JPasswordField();
         passwordTextField.setBounds(300, 200, 230, 30);
         passwordTextField.setFont(new Font("Arial",Font.BOLD,14));
         add(passwordTextField);
         
         
          login =new JButton("Sign in");
         login.setBounds(300, 250, 100, 30);
         login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
         login.addActionListener(this);
         add(login);
         
         
          clear =new JButton("CLEAR");
          clear.setBounds(430, 250, 100, 30);
          clear.setBackground(Color.BLACK);
          clear.setForeground(Color.WHITE);
          clear.addActionListener(this);
          add( clear );
         
         
          signup =new JButton("SIGN UP");
          signup.setBounds(300, 300, 230, 30);
          signup.setBackground(Color.BLACK);
          signup.setForeground(Color.WHITE);
          signup.setFont(new Font("Raleway",Font.BOLD,18));
          signup.addActionListener(this);
          add( signup );
         
         
         getContentPane().setBackground(Color.WHITE);
         
    setSize(800,400);
    setVisible(true);
    setLocation(350,200);
    }
    
  
    public static void main(String args[]) {
         new Login();
    }

  
  public void actioPerformed(ActionEvent ae){
        
}

    @Override
    public void actionPerformed(ActionEvent  ae) {
       if(ae.getSource()== clear){
            cardTextField.setText("");
            passwordTextField.setText("");
        }else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = passwordTextField.getText();
            String query = "select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";
          try{
             ResultSet rs =conn.s.executeQuery(query);
              if (rs.next()){
                 setVisible(false);
                  new Transaction(pinnumber).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null, "incorrect card number or pin");
              }
 
          } catch(Exception e){
                System.out.println(e);
            } 
        }else if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }}
 }

