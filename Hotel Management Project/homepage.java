import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class homepage extends JFrame implements ActionListener{
    
    homepage(){

        //FRAME
        setBounds(0,0,1000,665);
        setLayout(null);
        setVisible(true);

        //HALL WAY IMAGE
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("hallway-hotel.jpg"));
        JLabel hall = new JLabel(i);
        hall.setBounds(0,0,1000,665);
        add(hall);

        //LABEL
        JLabel hotelname = new JLabel("---Welcome to Our Hotel---");
        hotelname.setBounds (200,80, 1000 ,50);
        hotelname.setForeground(Color.WHITE);
        hotelname.setFont((new Font("serif", Font.BOLD, 50)));
        hall.add(hotelname);

        //MENU BAR
        JMenuBar bar = new JMenuBar();
        bar.setBounds(0,0,1000,50);
        hall.add(bar);

        //MENU
        JMenu menu1 = new JMenu ("Management");
        menu1.setForeground(Color.BLUE);
        bar.add(menu1);
        JMenu menu2 = new JMenu ("Admin");
        menu2.setForeground(Color.BLUE);
        bar.add(menu2);

        //MENU ITEMS
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        menu1.add(reception);

        JMenuItem addemployee= new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        menu2.add(addemployee);

        JMenuItem addmanager1= new JMenuItem("ADD MANAGER");
        addmanager1.addActionListener(this);
        menu2.add(addmanager1);

        JMenuItem addroom = new JMenuItem("ADD ROOM");
        addroom.addActionListener(this);
        menu2.add(addroom);

        JMenuItem updateemployee = new JMenuItem("UPDATE EMPLOYEE");
        updateemployee.addActionListener(this);
        menu2.add(addroom);
    
        JMenuItem dep = new JMenuItem("ADD DEPARTMENT");
        dep.addActionListener(this);
        menu2.add(dep);

    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getActionCommand().equals("ADD EMPLOYEE")){
            addemployee e = new addemployee();
        }
        else if (ae.getActionCommand().equals("ADD MANAGER")){
            addmanager e = new addmanager();
        }
        else if(ae.getActionCommand().equals("ADD ROOM")){
            addroom r = new addroom();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            reception rp = new reception();
        }
        else if(ae.getActionCommand().equals("UPDATE EMPLOYEE")){
            updateemployee u = new updateemployee();
        }
        else if(ae.getActionCommand().equals("ADD DEPARTMENT")){
            adddepartment u = new adddepartment();
        }

    }

    public static void main (String[]args){
        homepage h = new homepage();
    }
}
