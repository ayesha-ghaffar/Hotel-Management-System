import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.*; 

public class customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    customerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Customer ID");
        l1.setBounds(50,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("First Name");
        l2.setBounds(250,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Last Name");
        l3.setBounds(450,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Address");
        l4.setBounds(650,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Contact No.");
        l5.setBounds(850,10,100,20);
        add(l5);

        table = new JTable();
        table.setBounds(0,40,1050,400);
        add(table);

        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("Select * From CUSTOMER");
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
        new customerinfo();
    }
}