import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.*; 

public class  staffinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    staffinfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Staff ID");
        l1.setBounds(40,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("First Name");
        l2.setBounds(110,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Last Name");
        l3.setBounds(180,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(260,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(320,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Salary");
        l6.setBounds(390,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("Contact No.");
        l7.setBounds(460,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("Job Title");
        l8.setBounds(550,10,100,20);
        add(l8);

        JLabel l9 = new JLabel("Hire Date");
        l9.setBounds(6000,10,100,20);
        add(l9);

        JLabel l10 = new JLabel("Department ID");
        l10.setBounds(670,10,100,20);
        add(l10);

        JLabel l11 = new JLabel("Manager ID");
        l11.setBounds(780,10,100,20);
        add(l11);

        table = new JTable();
        table.setBounds(0,40,1050,400);
        add(table);

        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("Select * From STAFF");
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

        setBounds(100,50,1050,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }

    public static void main(String[]args){
        new staffinfo();
    }
}