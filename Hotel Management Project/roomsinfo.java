
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.*; 

public class roomsinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    roomsinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("allrooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel l1 = new JLabel("Room ID");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(200,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Capacity");
        l3.setBounds(380,10,100,20);
        add(l3);

        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);

        try{

            connect c = new connect();
            ResultSet rs = c.s.executeQuery("Select * From ROOM");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e){
            e.printStackTrace();
        }

    
        setBounds(50,50,1050,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }

    public static void main(String[]args){
        new roomsinfo();
    }
}