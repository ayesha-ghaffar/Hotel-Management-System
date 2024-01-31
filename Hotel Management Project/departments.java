import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import net.proteanit.sql.*; 

public class departments extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    departments(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Department ID");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Department Name");
        l2.setBounds(170,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Total Employees");
        l3.setBounds(340,10,100,20);
        add(l3);

        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("Select * From DEPARTMENT");
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

        setBounds(20,20,1050,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new reception();
    }

    public static void main(String[]args){
        new departments();
    }
}