import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class addcustomer extends JFrame implements ActionListener {

    JTextField fname1,fname2,faddress,fcontact,fcustomerID;
    JButton submit;
    Choice croom;

    addcustomer(){
        setLayout(null);
        setBounds(250,30,800,450);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD CUSTOMER DETAILS");
 

        //LABELS
        JLabel lname1 = new JLabel("FIRST NAME");
        lname1.setFont(new Font("serif", Font.PLAIN, 17));
        lname1.setBounds(60, 30, 150, 30);
        add(lname1);

        JLabel lname2 = new JLabel("LAST NAME");
        lname2.setFont(new Font("serif", Font.PLAIN, 17));
        lname2.setBounds(60, 80, 150, 30);
        add(lname2);

        JLabel laddress = new JLabel("ADDRESS");
        laddress.setFont(new Font("serif", Font.PLAIN, 17));
        laddress.setBounds(60, 130, 150, 30);
        add(laddress);

        JLabel lcontact = new JLabel("CONTACT NO");
        lcontact.setFont(new Font("serif", Font.PLAIN, 17));
        lcontact.setBounds(60, 180, 150, 30);
        add(lcontact);

        JLabel lcustomerID = new JLabel("CUSTOMER ID");
        lcustomerID.setFont(new Font("serif", Font.PLAIN, 17));
        lcustomerID.setBounds(60, 230, 150, 30);
        add(lcustomerID);

        JLabel room = new JLabel("ALLOTED ROOM NO");
        room.setFont(new Font("serif", Font.PLAIN, 16));
        room.setBounds(60, 280, 170, 30);
        add(room);


        
        //TEXTFIELDS
        fname1= new JTextField();
        fname1.setBounds(200, 30, 150, 30);
        add(fname1);

        fname2 = new JTextField();
        fname2.setBounds(200, 80, 150, 30);
        add(fname2);

        faddress = new JTextField();
        faddress.setBounds(200, 130, 150, 30);
        add(faddress);
        
        fcontact = new JTextField();
        fcontact.setBounds(200, 180, 150, 30);
        add(fcontact);

        fcustomerID= new JTextField();
        fcustomerID.setBounds(200, 230, 150, 30);
        add(fcustomerID);

        croom=new Choice();
        try{
            connect c = new connect();
            String query= "SELECT * FROM ROOM WHERE Availability = 'Y'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("RoomID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(250,280,150,150);
        add(croom);
                
        //ICON
        ImageIcon l = new ImageIcon(ClassLoader.getSystemResource("addc128.png"));
        JLabel loginimage = new JLabel(l);
        loginimage.setBounds(430,10,300,230);
        add(loginimage);


        //SUBMITBUTTON
        submit = new JButton("Submit");
        submit.setBounds(150,360,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String firstName = fname1.getText();
        String lastName= fname2.getText();
        String address = faddress.getText();
        String contact = fcontact.getText();
        String customerID = fcustomerID.getText();
        String room = croom.getSelectedItem();

        try{
           connect c  = new connect();
           Connection connection = c.getConnection();

           PreparedStatement pstmt = connection.prepareStatement("INSERT INTO CUSTOMER (CustomerID,FirstName,LastName,Address,ContactNo) VALUES (?, ?, ?, ? , ?)");

           pstmt.setString(1, customerID);
           pstmt.setString(2, firstName);
           pstmt.setString(3, lastName);
           pstmt.setString(4, address);
           pstmt.setString(5, contact);

           
           String available="UPDATE ROOM SET Availability ='N' where RoomID = '"+room+"' "; 
           pstmt.executeUpdate();
           c.s.executeUpdate(available);

            JOptionPane.showMessageDialog(null," New Customer Added Successfully");
            setVisible(false);
            new reception();
    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        addcustomer a = new addcustomer();
    }
}