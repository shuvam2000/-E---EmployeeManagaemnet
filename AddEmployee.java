
package employeee1.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.sql.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfadhar,tfsalary,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblemp;
    JButton add,back;
    
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD EMPLOYEE DETILS");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        
        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        add(labelname);
        
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.BOLD,20));
        add(labelfname);
       
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.BOLD,20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.BOLD,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.BOLD,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        
        
        JLabel labelphone = new JLabel("Phone No");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.BOLD,20));
        add( labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        
        JLabel labelemail = new JLabel("Email id");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.BOLD,20));
        add( labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.BOLD,20));
        add( labeleducation);
        
        String courses[] = {"BTEK","BBA", "MCA", "BIO-TEch","BA"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add( cbeducation);
        
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.BOLD,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        
        
        JLabel labeladhar = new JLabel("Adhar No");
        labeladhar.setBounds(400,350,150,30);
        labeladhar.setFont(new Font("serif",Font.BOLD,20));
        add( labeladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add( tfadhar);
        
        JLabel labelemp = new JLabel("Emp id");
        labelemp.setBounds(50,400,150,30);
        labelemp.setFont(new Font("serif",Font.BOLD,20));
        add( labelemp);
        
        
        lblemp = new JLabel(" " + number);
        lblemp.setBounds(200,400,150,30);
        lblemp.setFont(new Font("serif",Font.BOLD,20));
        add( lblemp);
        
        
        add = new JButton("ADD EMPLOYEE");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
     
    
    public void actionPerformed(ActionEvent ae) {
      
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String)cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String adhar = tfadhar.getText();
            String empId = lblemp.getText();
            try{
                Conn Conn = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+empId+"')";
           
               Conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
                
            }
            }else {
            setVisible(false);
            new Home();
        }
            
    }
        
   

    public static void main(String[] args){
        new AddEmployee();
    }

  
   
    
}
