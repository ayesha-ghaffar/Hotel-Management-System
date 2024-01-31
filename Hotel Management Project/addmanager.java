import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate; 

public class addmanager extends JFrame implements ActionListener {

     JLabel date;
     LocalDate hiredate ;
    JTextField fname1,fname2,fage,fsalary,fcontact,fid,fdepid,fmid;
    JComboBox dropdown;
    JRadioButton malebutton,femalebutton;
    JButton submit;

    addmanager(){
        setLayout(null);
        setBounds(250,30,800,670);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD MANAGER DETAILS");
 

        //LABELS
        JLabel lname1 = new JLabel("FIRST NAME");
        lname1.setFont(new Font("serif", Font.PLAIN, 17));
        lname1.setBounds(60, 30, 150, 30);
        add(lname1);

        JLabel lname2 = new JLabel("LAST NAME");
        lname2.setFont(new Font("serif", Font.PLAIN, 17));
        lname2.setBounds(60, 80, 150, 30);
        add(lname2);

        JLabel lage = new JLabel("AGE");
        lage.setFont(new Font("serif", Font.PLAIN, 17));
        lage.setBounds(60, 130, 150, 30);
        add(lage);

        JLabel lgender = new JLabel("GENDER");
        lgender.setFont(new Font("serif", Font.PLAIN, 17));
        lgender.setBounds(60, 180, 150, 30);
        add(lgender);

        JLabel lsalary = new JLabel("SALARY");
        lsalary.setFont(new Font("serif", Font.PLAIN, 17));
        lsalary.setBounds(60, 230, 150, 30);
        add(lsalary);

        JLabel lcontact = new JLabel("CONTACT NO");
        lcontact.setFont(new Font("serif", Font.PLAIN, 17));
        lcontact.setBounds(60, 280, 150, 30);
        add(lcontact);

        JLabel ldate = new JLabel("HIRE DATE");
        ldate.setFont(new Font("serif", Font.PLAIN, 17));
        ldate.setBounds(60, 330, 150, 30);
        add(ldate);

        hiredate = LocalDate.now();
        date=new JLabel(""+ hiredate);
        date.setFont(new Font("serif", Font.PLAIN, 17));
        date.setBounds(200, 330, 150, 30);
        add(date);

        JLabel ldepid = new JLabel("DEP ID");
        ldepid.setFont(new Font("serif", Font.PLAIN, 17));
        ldepid.setBounds(60, 380, 150, 30);
        add(ldepid);

        JLabel lmid = new JLabel("MANAGER ID");
        lmid.setFont(new Font("serif", Font.PLAIN, 17));
        lmid.setBounds(60, 430, 150, 30);
        add(lmid);

        //TEXTFIELDS
        fname1= new JTextField();
        fname1.setBounds(200, 30, 150, 30);
        add(fname1);

        fname2= new JTextField();
        fname2.setBounds(200, 80, 150, 30);
        add(fname2);

        fage= new JTextField();
        fage.setBounds(200, 130, 150, 30);
        add(fage);
        
         malebutton= new JRadioButton("MALE");
        malebutton.setBackground(Color.WHITE);
        malebutton.setBounds(200, 180, 70, 27);
        add(malebutton);

        femalebutton= new JRadioButton("FEMALE");
        femalebutton.setBackground(Color.WHITE);
        femalebutton.setBounds(280, 180, 90, 27);
        add(femalebutton);

        ButtonGroup selectone=new ButtonGroup();
        selectone.add(femalebutton);
        selectone.add(malebutton);

        fsalary= new JTextField();
        fsalary.setBounds(200, 230, 150, 30);
        add(fsalary);
       

        fcontact= new JTextField();
        fcontact.setBounds(200, 280, 150, 30);
        add(fcontact);

        fdepid= new JTextField();
        fdepid.setBounds(200, 380, 150, 30);
        add(fdepid);

        fmid= new JTextField();
        fmid.setBounds(200, 430, 150, 30);
        add(fmid);

                
        //ICON
        ImageIcon l = new ImageIcon(ClassLoader.getSystemResource("employee256.png"));
        JLabel loginimage = new JLabel(l);
        loginimage.setBounds(430,100,300,300);
        add(loginimage);


        //SUBMITBUTTON
        submit = new JButton("Submit");
        submit.setBounds(150,570,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String fn = fname1.getText();
        String ln= fname2.getText();
        String age= fage.getText();
        String salary = fsalary.getText();
        String contact = fcontact.getText();


        String gender = null;
        if(malebutton.isSelected()){
            gender = "M";
        }
        else if(femalebutton.isSelected()){
            gender = "F";
        }

        java.sql.Date sqlDate = java.sql.Date.valueOf(hiredate);
        String depid=fdepid.getText();
        String mid=fmid.getText();

        try{

           connect c  = new connect();
           Connection connection = c.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO MANAGER (ManagerID, FirstName,LastName, Age, Gender, Salary, Contactno,HireDate,DepID) VALUES (?, ?, ?, ? , ?, ?, ?, ?, ?)");


           // Set the employee details
           pstmt.setString(1, mid);
           pstmt.setString(2, fn);
           pstmt.setString(3, ln);
           pstmt.setInt(4, Integer.parseInt(age));
           pstmt.setString(5, gender);
           pstmt.setInt(6, Integer.parseInt(salary));
           pstmt.setString(7, (contact));
           pstmt.setDate(8, sqlDate);
           pstmt.setString(9,depid);

           pstmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null,"Manager Added");
            setVisible(false);
        
        } 
            catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        addmanager a = new addmanager();
    }
}
