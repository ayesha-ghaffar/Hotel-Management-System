import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class addroom extends JFrame implements ActionListener {

    JTextField froomID,fcapacity;
    JRadioButton yesbutton,nobutton;
    JButton submit;

    addroom(){
        setLayout(null);
        setBounds(250,30,800,300);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD ROOM DETAILS");
 

        //LABELS
        JLabel lroomID = new JLabel("ROOM ID");
        lroomID.setFont(new Font("serif", Font.PLAIN, 17));
        lroomID.setBounds(60, 30, 150, 30);
        add(lroomID);

        JLabel lcapacity = new JLabel("CAPACITY");
        lcapacity.setFont(new Font("serif", Font.PLAIN, 17));
        lcapacity.setBounds(60, 80, 150, 30);
        add(lcapacity);

        JLabel lavailability = new JLabel("AVAILABILITY");
        lavailability.setFont(new Font("serif", Font.PLAIN, 17));
        lavailability.setBounds(60, 130, 150, 30);
        add(lavailability);

        //TEXTFIELDS
        froomID = new JTextField();
        froomID.setBounds(200, 30, 150, 30);
        add(froomID);

        fcapacity = new JTextField();
        fcapacity.setBounds(200, 80, 150, 30);
        add(fcapacity);
        
        yesbutton= new JRadioButton("YES");
        yesbutton.setBackground(Color.WHITE);
        yesbutton.setBounds(200, 130, 70, 27);
        add(yesbutton);
        nobutton= new JRadioButton("NO");
        nobutton.setBackground(Color.WHITE);
        nobutton.setBounds(280, 130, 90, 27);
        add(nobutton);

        ButtonGroup selectone=new ButtonGroup();
        selectone.add(yesbutton);
        selectone.add(nobutton);
   
        //ICON
        ImageIcon l = new ImageIcon(ClassLoader.getSystemResource("addroom128.png"));
        JLabel loginimage = new JLabel(l);
        loginimage.setBounds(430,0,300,300);
        add(loginimage);


        //SUBMITBUTTON
        submit = new JButton("Submit");
        submit.setBounds(150,200,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String roomID = froomID.getText();
        String capacity= fcapacity.getText();

        String availability = null;
        if(yesbutton.isSelected()){
            availability = "Y";
        }
        else if(nobutton.isSelected()){
            availability = "N";
        }

        try{

            System.out.println(roomID);
            System.out.println(capacity);
            System.out.println(availability);
        
           connect c  = new connect();
           Connection connection = c.getConnection();
           // String str = "INSERT INTO STAFF values( '"+staffid+"', '"+fn+"', '"+ln+"','"+age+"', '"+gender+"', '"+salary+"','"+contact+"', '"+job+"','"+sqlDate+"','"+depid+"','"+mid+"')";             
           // c.s.executeUpdate(str);
           PreparedStatement pstmt = connection.prepareStatement("INSERT INTO ROOM(RoomID, Availability,Capacity) VALUES (?, ?, ?)");
           // Set the room details
           pstmt.setString(1, roomID);
           pstmt.setString(2, availability);
            pstmt.setInt(3, Integer.parseInt(capacity));

           // Execute the prepared statement to insert the room
           pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Room Added");
            setVisible(false);
    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        addroom a = new addroom();
    }
}