import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem(){

        //FRAME
        setSize(2000, 1335);
        setVisible(true);
        
        //HOTEL PIC
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("hotelfront.jpg"));
        JLabel frontimage = new JLabel(i);
        frontimage.setBounds(0,0,2000,1335);
        add(frontimage);

        //HOTEL NAME
        JLabel hotelname = new JLabel("Hotel Management System");
        hotelname.setBounds (20,500, 1000 ,90);
        hotelname.setForeground(Color.BLACK);
        hotelname.setFont((new Font("serif", Font.BOLD, 50)));
        frontimage.add(hotelname);

        //NEXT BUTTON
        JButton nextbutton = new JButton("Next");
        nextbutton.setBounds(1000,530, 150,50);
        nextbutton.setBackground(Color.BLACK);
        nextbutton.setForeground(Color.WHITE);
        nextbutton.setFont((new Font("serif", Font.BOLD, 20)));
        nextbutton.addActionListener(this);
        frontimage.add(nextbutton);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        login l = new login ();

    }
    public static void main(String [] args){
        HotelManagementSystem h = new HotelManagementSystem();
    }
}