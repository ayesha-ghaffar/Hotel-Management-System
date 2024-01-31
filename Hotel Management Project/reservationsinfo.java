import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.*; 

public class reservationsinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    reservationsinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Reservation ID");
        l1.setBounds(40,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Price");
        l2.setBounds(180,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Room ID");
        l3.setBounds(320,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Customer ID");
        l4.setBounds(460,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Check-In Date");
        l5.setBounds(600,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Check-Out Date");
        l6.setBounds(740,10,100,20);
        add(l6);

        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("Select * From RESERVATION");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);

        setBounds(300,200,1050,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }

    public static void main(String[]args){
        new reservationsinfo();
    }
}