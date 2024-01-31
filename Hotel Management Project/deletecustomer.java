import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class deletecustomer extends JFrame implements ActionListener {

    JButton delete;
    Choice cr;

    deletecustomer(){

        setLayout(null);
        setBounds(250,30,500,280);
        getContentPane().setBackground(Color.WHITE);
        setTitle("REMOVE CUSTOMER");
 

        //LABELS
        JLabel lname1 = new JLabel("CUSTOMER ID");
        lname1.setFont(new Font("serif", Font.PLAIN, 17));
        lname1.setBounds(60, 30, 120, 30);
        add(lname1);

        
        cr=new Choice();
        try{
            connect c = new connect();
            String query= "SELECT * FROM CUSTOMER ";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                cr.add(rs.getString("CustomerID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        cr.setBounds(200,30,200,30);
        add(cr);

        //DELETEBUTTON
        delete = new JButton("Delete");
        delete.setBounds(150,100,100,30);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        delete.setBackground(Color.black);
        add(delete);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){


         try{
            
            String id = cr.getSelectedItem();
            connect c = new connect();
            Connection connection = c.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM CUSTOMER WHERE CustomerID = ?");

            pstmt.setString(1,id );

            int numdel= pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null,numdel+" Rows Deleted Successfully");
            setVisible(false);
            new reception();
    


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        deletecustomer a = new deletecustomer();
    }
}