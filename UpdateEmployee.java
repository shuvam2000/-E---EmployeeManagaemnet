
package employeee1.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;




public class UpdateEmployee extends JFrame implements ActionListener{
    
    
 
    
    
    JTextField tfeducation,tffname,tfaddress,tfphone,tfemail,tfadhar,tfsalary,tfdesignation;
    
    JLabel lblemp;
    JButton add,back;
    String empId;
    
   UpdateEmployee(String empId){
       this.empId = empId;
        
        getContentPane().setBackground(Color.red);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE EMPLOYEE DETILS");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        
        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        add(labelname);
        
        
        JLabel lblname = new JLabel();
       lblname.setBounds(200,150,150,30);
        add(lblname);
        
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
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        
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
        
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add( tfeducation);
        
        
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
        
        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(600,350,150,30);
        add( lbladhar);
        
        JLabel labelemp = new JLabel("Emp id");
        labelemp.setBounds(50,400,150,30);
        labelemp.setFont(new Font("serif",Font.BOLD,20));
        add( labelemp);
        
        
        lblemp = new JLabel();
        lblemp.setBounds(200,400,150,30);
        lblemp.setFont(new Font("serif",Font.BOLD,20));
        add( lblemp);
        
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where emp = '"+empId+"'";
           ResultSet rs =  c.s.executeQuery(query);
           while(rs.next()) {
               lblname.setText(rs.getString("name"));
               tffname.setText(rs.getString("fname"));
               lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                 tfaddress.setText(rs.getString("address"));
            tfphone.setText(rs.getString("phone"));
             tfemail.setText(rs.getString("email"));
              tfeducation.setText(rs.getString("education"));
               tfdesignation.setText(rs.getString("designation"));
               lbladhar.setText(rs.getString("adhar"));
                 lblemp.setText(rs.getString("emp"));
               
               
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        add = new JButton("UPDATE DETAILS");
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
          
            String fname = tffname.getText();
          
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try{
                Conn Conn = new Conn();
                String query = "update  employee set fname ='"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where emp = '"+empId+"'";
           
               Conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated Successfully");
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
        new UpdateEmployee("");
    }

  
   
    
}
