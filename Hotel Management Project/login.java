
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{

      JButton loginbutton,cancelbutton;
       JTextField user;
      JPasswordField passw;
      public int password = 12345;

    login(){
   
        //FRAME
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // LABELS
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        setVisible(true);
  
        //TEXTFIELDS
        user = new JTextField ();
        user.setBounds(150, 20, 140, 30);
        add(user);
        passw = new JPasswordField();
        passw.setBounds(150, 70, 140, 30);
        add(passw);

        //BUTTONS
        loginbutton = new JButton("Login");
        loginbutton.setBounds(40,150,120,30);
        loginbutton.setBackground(Color.BLACK);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.addActionListener(this);
        add(loginbutton);

        cancelbutton = new JButton("Cancel");
        cancelbutton.setBounds(180,150,120,30);
        cancelbutton.setBackground(Color.BLACK);
        cancelbutton.setForeground(Color.WHITE);
        cancelbutton.addActionListener(this);
        add(cancelbutton);

        //ICON
        ImageIcon l = new ImageIcon(ClassLoader.getSystemResource("loginn128.png"));
        JLabel loginimage = new JLabel(l);
        loginimage.setBounds(350,10,200,200);
        add(loginimage);

        setBounds(500,200,600,300);
        setVisible(true);  
    }

    public void actionPerformed(ActionEvent ae) {
        int maxAttempts = 3;
    
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            String u = user.getText();
            String p = new String(passw.getPassword());
    
    
            if (!u.matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(login.this, "Invalid Username. Please enter alphabets only.");
                return;
            }
    
            if (!p.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(login.this, "Invalid Password. Please enter numbers only.");
                return;
            }
    
            String staticUsername = "admin";
            String staticPassword = "12345";
    
            if (u.equals(staticUsername) && p.equals(staticPassword)) {
                JOptionPane.showMessageDialog(login.this, "Login Successful");
                setVisible(false);
                homepage h = new homepage();
                return; 
            } else {
                JOptionPane.showMessageDialog(login.this, "Invalid Username or Password. Attempt " + attempt + "/" + maxAttempts);
                if (attempt < maxAttempts) {
                    
                    user.setText("");
                    passw.setText("");
                }
            }
        }
    
        JOptionPane.showMessageDialog(login.this, "Maximum login attempts reached. Exiting application.");
        System.exit(0);
    }

 public static void main (String [] args){
        login l = new login ();
    }
}
