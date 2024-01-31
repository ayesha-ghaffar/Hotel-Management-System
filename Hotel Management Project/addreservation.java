import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate; 

public class addreservation extends JFrame implements ActionListener {

     JLabel date;
     LocalDate checkInDate;
     LocalDate checkOutDate;
    JTextField freservationID,fcustomerID,froomID,fprice,fstaydays;
    JButton submit;

    addreservation(){
        setLayout(null);
        setBounds(150,30,1000,670);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD RESERVATION DETAILS");
 

        //LABELS
        JLabel lreservationID = new JLabel("RESERVATION ID");
        lreservationID.setFont(new Font("serif", Font.PLAIN, 16));
        lreservationID.setBounds(60, 30, 150, 30);
        add(lreservationID);

        JLabel lcustomerID = new JLabel("CUSTOMER ID");
        lcustomerID.setFont(new Font("serif", Font.PLAIN, 17));
        lcustomerID.setBounds(60, 80, 150, 30);
        add(lcustomerID);

        JLabel lroomID = new JLabel("ROOM ID");
        lroomID.setFont(new Font("serif", Font.PLAIN, 17));
        lroomID.setBounds(60, 130, 150, 30);
        add(lroomID);

        JLabel lprice = new JLabel("TOTAL PRICE");
        lprice.setFont(new Font("serif", Font.PLAIN, 17));
        lprice.setBounds(60, 180, 150, 30);
        add(lprice);

        JLabel lcheckInDate = new JLabel("CHECK-IN DATE");
        lcheckInDate.setFont(new Font("serif", Font.PLAIN, 17));
        lcheckInDate.setBounds(60, 230, 150, 30);
        add(lcheckInDate);

        checkInDate = LocalDate.now();
        date=new JLabel(""+ checkInDate);
        date.setFont(new Font("serif", Font.PLAIN, 17));
        date.setBounds(280, 230, 150, 30);
        add(date);

        JLabel lstaydays = new JLabel("NUMBER OF DAYS OF STAY");
        lstaydays.setFont(new Font("serif", Font.PLAIN, 15));
        lstaydays.setBounds(60, 280, 200, 30);
        add(lstaydays);

        //TEXTFIELDS
        freservationID = new JTextField();
        freservationID.setBounds(200, 30, 150, 30);
        add(freservationID);

        fcustomerID = new JTextField();
        fcustomerID.setBounds(200, 80, 150, 30);
        add(fcustomerID);

        froomID= new JTextField();
        froomID.setBounds(200, 130, 150, 30);
        add(froomID);

        fprice = new JTextField();
        fprice.setBounds(200, 180, 150, 30);
        add(fprice);

        fstaydays= new JTextField();
        fstaydays.setBounds(280, 280, 150, 30);
        add(fstaydays);
                
        //ICON
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("reservepic.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);


        //SUBMITBUTTON
        submit = new JButton("Submit");
        submit.setBounds(150,520,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String reservationID = freservationID.getText();
        String customerID = fcustomerID.getText();
        String roomID = froomID.getText();
        String price = fprice.getText();
        String staydays= fstaydays.getText();

        java.sql.Date sqlDate1 = java.sql.Date.valueOf(checkInDate);
        java.sql.Date sqlDate2 = java.sql.Date.valueOf(checkInDate.plusDays(Integer.parseInt(staydays)));
         
        
        try{

           connect c  = new connect();
           Connection connection = c.getConnection();

           PreparedStatement pstmt = connection.prepareStatement("INSERT INTO RESERVATION (ReservationID,Price,RoomID,CustomerID,CheckIn_Date,CheckOut_Date) VALUES (?,?,?,?,?,?)");


           pstmt.setString(1, reservationID);
           pstmt.setInt(2, Integer.parseInt(price));        
           pstmt.setString(3, roomID);
           pstmt.setString(4, customerID);
           pstmt.setDate(5, sqlDate1);
           pstmt.setDate(6, sqlDate2);
           
           pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Reservation Added");
            setVisible(false);
    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        addreservation a = new addreservation();
    }
}