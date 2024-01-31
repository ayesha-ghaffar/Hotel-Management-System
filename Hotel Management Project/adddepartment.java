import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate; 

public class adddepartment extends JFrame implements ActionListener {


    JTextField id, n ,t;
    JButton submit;

    adddepartment(){
        setLayout(null);
        setBounds(150,30,1000,480);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD DEPARTMENT DETAILS");
 

        //LABELS
        JLabel dp = new JLabel("DEPARTMENT ID");
        dp.setFont(new Font("serif", Font.PLAIN, 16));
        dp.setBounds(60, 30, 150, 30);
        add(dp);

        JLabel dn = new JLabel("DEPT NAME");
        dn.setFont(new Font("serif", Font.PLAIN, 16));
        dn.setBounds(60, 80, 160, 30);
        add(dn);

        JLabel e = new JLabel("TOTAL EMPLOYEES");
        e.setFont(new Font("serif", Font.PLAIN, 16));
        e.setBounds(60, 130, 170, 30);
        add(e);

        //TEXTFIELDS
        id = new JTextField();
        id.setBounds(250, 30, 150, 30);
        add(id);

        n = new JTextField();
        n.setBounds(250, 80, 150, 30);
        add(n);

        t= new JTextField();
        t.setBounds(250, 130, 150, 30);
        add(t);

                
        //ICON
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("addroom128.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(650,30,200,200);
        add(image);


        //SUBMITBUTTON
        submit = new JButton("Submit");
        submit.setBounds(150,250,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String did = id.getText();
        String dname = n.getText();
        String total = t.getText();
   
         
        
        try{
           connect c  = new connect();
           Connection connection = c.getConnection();

           PreparedStatement pstmt = connection.prepareStatement("INSERT INTO DEPARTMENT (DepID,DepName, TotalEmployees) VALUES (?,?,?)");


           pstmt.setString(1, did);        
           pstmt.setString(2, dname);
           pstmt.setString(3, total);
           
           
           pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Department Added");
            setVisible(false);
    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        adddepartment a = new adddepartment();
    }
}