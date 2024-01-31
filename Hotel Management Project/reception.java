import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate; 

public class reception extends JFrame  implements ActionListener{
    reception(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("RECEPTION");

        //BUTTONS
        JButton addcustomer = new JButton("ADD CUSTOMER");
        addcustomer.setBounds(10,30,200,30);
        addcustomer.setBackground(Color.BLACK);
        addcustomer.setForeground(Color.WHITE);
        addcustomer.addActionListener(this);
        add(addcustomer);

        JButton rooms = new JButton("ROOMS");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        JButton departments = new JButton("DEPARTMENTS");
        departments.setBounds(10,110,200,30);
        departments.setBackground(Color.BLACK);
        departments.setForeground(Color.WHITE);
        departments.addActionListener(this);
        add(departments);

        JButton employees= new JButton("ALL EMPLOYEES");
        employees.setBounds(10,150,200,30);
        employees.setBackground(Color.BLACK);
        employees.setForeground(Color.WHITE);
        employees.addActionListener(this);
        add(employees);

        JButton customers = new JButton("CUSTOMER INFO");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        JButton managers = new JButton("MANAGER INFO");
        managers.setBounds(10,230,200,30);
        managers.setBackground(Color.BLACK);
        managers.setForeground(Color.WHITE);
        managers.addActionListener(this);
        add(managers);

        JButton checkout = new JButton("REMOVE CUSTOMER");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        JButton update = new JButton("ADD RESERVATION");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);


        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("reception1000x667.jpg"));
        JLabel hall = new JLabel(i);
        hall.setBounds(250,30,500,470);
        add(hall);


        setBounds(100,100,800,550);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){

        if(ae.getActionCommand().equals("ADD CUSTOMER")){
            setVisible(false);
            new addcustomer();
        }
        else if(ae.getActionCommand().equals("ROOMS")){
            setVisible(false);
            new roomsinfo();   
        }
        else if(ae.getActionCommand().equals("DEPARTMENTS")){
            setVisible(false);
            new departments();   
        }
        else if(ae.getActionCommand().equals("ALL EMPLOYEES")){
            setVisible(false);
            new staffinfo(); 
        }
        else if(ae.getActionCommand().equals("CUSTOMER INFO")){
            setVisible(false);
            new customerinfo(); 
        }
        else if(ae.getActionCommand().equals("MANAGER INFO")){
            setVisible(false);
            new managerinfo(); 
        }
        else if(ae.getActionCommand().equals("CHECKOUT")){}
        else if(ae.getActionCommand().equals("UPDATE STATUS")){}
        else if(ae.getActionCommand().equals("UPDATE ROOM STATUS")){}
        else if(ae.getActionCommand().equals("VIEW RESERVATIONS")){
            setVisible(false);
           new  reservationsinfo();
        }
        else if(ae.getActionCommand().equals("REMOVE CUSTOMER")){
            setVisible(false);
            new deletecustomer(); 
        }
        else if(ae.getActionCommand().equals("ADD RESERVATION")){
            setVisible(false);
            new addreservation(); 
        }

    }

    public static void main(String[]args){
        reception r = new reception();
    }
}