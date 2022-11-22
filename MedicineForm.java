//…………………………………………..Medicine Form…………………………………………………..//
package medicalsystem;
import java.awt.*;

import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.awt.event.*;



 public class MedicineForm extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4;
    JLabel l,l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    
    JFrame f;
    
    Connection con;
    ResultSet rs;
    PreparedStatement ps=null;
    Statement stmt=null;
  
  MedicineForm()
  

   {
	   f=new JFrame("MedicineDetails");
	   f.setVisible(true);
       f.setLayout(null);
       l5=new JLabel("ADD MEDICINES");
       
       l=new JLabel("Medicine Name");
       l1=new JLabel("Type");
       l2=new JLabel("Price");
       l3=new JLabel("mfgdate");
       l4=new JLabel("expdate");

       t1=new JTextField(10);
       t2=new JTextField(10);
       t3=new JTextField(10);
       t4=new JTextField(10);
       t5=new JTextField(10);
       
       b1=new JButton("ADD");
       b2=new JButton("DELETE");
      b3=new JButton("NEXT");
      b4=new JButton("PREV");
      
      l5.setBounds(200,30,160,70);
      l5.setForeground(Color.RED);
      l5.setFont(new Font("serif",Font.BOLD,15));
        l.setBounds(100,100,100,30);
        t1.setBounds(200,100,150,30);
        l1.setBounds(100,150,100,30);        
        t2.setBounds(200,150,150,30);
        l2.setBounds(100,200,100,30); 
        t3.setBounds(200,200,150,30);
        l3.setBounds(100,250,100,30);
        t4.setBounds(200,250,150,30);
        l4.setBounds(100,300,100,30);
        t5.setBounds(200,300,150,30);
        b1.setBounds(150,350,90,40);
        b2.setBounds(250,350,90,40);
       b3.setBounds(300,400,90,30);
       b4.setBounds(400,400,90,30);
       l.setForeground(Color.BLUE);
       l.setFont(new Font("serif",Font.BOLD,13));
       l1.setForeground(Color.BLUE);
       l1.setFont(new Font("serif",Font.BOLD,13));
       l2.setForeground(Color.BLUE);
       l2.setFont(new Font("serif",Font.BOLD,13));
       l3.setForeground(Color.BLUE);
       l3.setFont(new Font("serif",Font.BOLD,13));
       l4.setForeground(Color.BLUE);
       l4.setFont(new Font("serif",Font.BOLD,13));
       b1.setBackground(Color.green);
       b1.setForeground(Color.WHITE);
       b2.setBackground(Color.green);
       b2.setForeground(Color.WHITE);
       b3.setBackground(Color.green);
       b3.setForeground(Color.WHITE);
       b4.setBackground(Color.green);
       b4.setForeground(Color.WHITE);
       f.setBackground(Color.YELLOW);
       f.getContentPane().setBackground(Color.pink);
      

      f.add(l5);  
     f.add(l);
     f.add(t1);
     
        f.add(l1); 
        f.add(t2); 
        f.add(l2); 
        f.add(t3); 
        f.add(l3);
        f.add(t4);
        f.add(l4);
        f.add(t5);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.setTitle("MEDICINE DETAILS");
        
        f.setSize(600,600);
               f.setResizable(false);
        f.setLocationRelativeTo(null);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
   
  
	  b1.addActionListener(new ActionListener()
			  {
			public void actionPerformed(ActionEvent ae)
		
	  
	  {
				
	       try
	     	  {
	     		  Class.forName("com.mysql.cj.jdbc.Driver");
	     		  con=DriverManager.getConnection("jdbc:mysql://localhost/medicalbillingsystem?serverTimezone=UTC","root","");
	     		  
	     	  
						
	     	 
	     		  
	      	String mname,type;
	      	int price;
	      	String mfgdate,expdate;
	      
	      		
	      		
	      		mname=t1.getText();
	      		type=t2.getText();
	      		price=Integer.parseInt(t3.getText());
	      		mfgdate=t4.getText();
	      		
	      		expdate=t5.getText();
	      		
	      		
	      		
	      		
	      		
	      				ps=con.prepareStatement("insert into medicine1 values(?,?,?,?,?)");
	      				ps.setString(1,mname);
	      				ps.setString(2,type);
	      				ps.setInt(3,price);
	      				ps.setString(4,mfgdate);
	      				ps.setString(5,expdate);
	      				ps.executeUpdate();
	      				JOptionPane.showMessageDialog(f,"Record inserted successfully");
	      				
	      				String sql;
	      				sql="Select * from medicine1";
	      				stmt=con.createStatement();
	      				rs=stmt.executeQuery(sql);
	      				
	      			    t1.setText("");
	      			    t1.setEditable(false);
	      				t2.setText("");
	      				t3.setText("");
	      				t4.setText("");
	      				t5.setText("");
	      				
	      				
	      				
	      				
	      			
	      			
	      		}
	      		catch(Exception e)
	      		{
	      			System.out.println(e);
	      		}}});
	     	  
	      		
   }
	  
	  
public void actionPerformed(ActionEvent e)
{
  		
		if(e.getSource()==b3)
	  {
		  new CustomerDetails();
      	  f.setVisible(false);
	  }
	  else if(e.getSource()==b4)
	  {
		  System.out.println("First Page");
		  f.setVisible(false);
	  }
	
  }

	public static void main(String[] args) {
		MedicineForm mf=new MedicineForm();

	}

}


