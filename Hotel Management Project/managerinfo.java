import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.*; 

public class managerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    managerinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Manager ID");
        l1.setBounds(40,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("First Name");
        l2.setBounds(140,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Last Name");
        l3.setBounds(240,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(340,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(440,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Salary");
        l6.setBounds(540,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("Contact No.");
        l7.setBounds(640,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("Hire Date");
        l8.setBounds(740,10,100,20);
        add(l8);

        JLabel l9 = new JLabel("Department ID");
        l9.setBounds(840,10,100,20);
        add(l9);

        table = new JTable();
        table.setBounds(0,40,1050,400);
        add(table);

        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("Select * From MANAGER");
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

        setBounds(150,100,1050,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }

    public static void main(String[]args){
        new managerinfo();
    }
}