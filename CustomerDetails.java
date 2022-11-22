
//………………………………………..Add Sell……………………………………….//
package medicalsystem;
import java.awt.*;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
import javax.swing.*;
@SuppressWarnings("serial")

public class CustomerDetails extends JFrame implements ActionListener
{
  JButton b1,b2,b3,b4,b5,b6;
  JLabel l,l1,l2,l3,l5;
  JTextField t1,t2,t3,t4;

  JFrame f;
  Connection con;
  ResultSet rs=null;
  PreparedStatement ps;
  Statement stmt;
  
CustomerDetails()
 {
	  f=new JFrame();
	  f.setVisible(true);
    f.setLayout(null);
    l5=new JLabel("CUSTOMER DETAILS");
	  l=new JLabel("Customer ID");
    l1=new JLabel("Customer Name");
    l2=new JLabel("Customer Address");
     l3=new JLabel("Customer Mobile");
     
     t1=new JTextField(10);
     t2=new JTextField(10);
     t3=new JTextField(10);
     t4=new JTextField(10);
     b1=new JButton("SAVE");
    b2=new JButton("NEXT");
     b3=new JButton("PREV");
    /* b4=new JButton("VIEW");
     b5=new JButton("EXIT");
     b6=new JButton("");*/
    
     f.getContentPane().setBackground(Color.pink);
     l5.setBounds(200,30,160,70);
     l5.setForeground(Color.RED);
     l5.setFont(new Font("serif",Font.BOLD,15));
     l.setBounds(100,100,100,30);
     t1.setBounds(220,100,150,30);
     l1.setBounds(100,150,100,30);        
     t2.setBounds(220,150,150,30);
     l2.setBounds(100,200,100,30); 
     t3.setBounds(220,200,150,30);
     l3.setBounds(100,250,100,30);
     t4.setBounds(220,250,150,30);
     b1.setBounds(220,300,100,30);
     b2.setBounds(180,350,80,30);
     b3.setBounds(280,350,80,30);
     /*b4.setBounds(450,350,100,30);
     b5.setBounds(550,350,100,30);
     b6.setBounds(250,350,100,30);*/
     l.setForeground(Color.BLUE);
     l.setFont(new Font("serif",Font.BOLD,13));
     l1.setForeground(Color.BLUE);
     l1.setFont(new Font("serif",Font.BOLD,13));
     l2.setForeground(Color.BLUE);
     l2.setFont(new Font("serif",Font.BOLD,13));
     l3.setForeground(Color.BLUE);
     l3.setFont(new Font("serif",Font.BOLD,13));
    /* l4.setForeground(Color.BLUE);
     l4.setFont(new Font("serif",Font.BOLD,13));*/
     b1.setBackground(Color.green);
     b1.setForeground(Color.WHITE);
     b2.setBackground(Color.green);
     b2.setForeground(Color.WHITE);
     b3.setBackground(Color.green);
     b3.setForeground(Color.WHITE);
  
      f.add(l);  f.add(t1);  f.add(l1);  f.add(t2);
      f.add(l2);f.add(t3);f.add(l3);f.add(t4);f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(l5);
     /* f.add(b4);
      f.add(b5);
      f.add(b6);*/
      

      
      f.setTitle("MEDICINE BILLING-CUSTOMER DETAILS");
      f.setSize(600,600);
     
      f.setResizable(false);
      f.setLocationRelativeTo(null);
      b1.addActionListener(this);
     b2.addActionListener(this);
      b3.addActionListener(this);
      /*b4.addActionListener(this);
      this.getContentPane().setBackground(Color.PINK);
      b5.addActionListener(this);
      this.getContentPane().setBackground(Color.PINK);
      b6.addActionListener(this);*/
      
     /* t1.addKeyListener(this);
      t2.addKeyListener(this);
      
      b1.setToolTipText("save the Record");
      b2.setToolTipText("add new Record");
      b5.setToolTipText("exit");*/
 }

public void actionPerformed(ActionEvent ae)
  {
       try
     	  {
     		  Class.forName("com.mysql.cj.jdbc.Driver");
     		  con=DriverManager.getConnection("jdbc:mysql://localhost/medicalbillingsystem?serverTimezone=UTC","root","");
     		  stmt=con.createStatement();
     		    
     	  }
     	  catch(Exception e)
     	  {
     		 JOptionPane.showMessageDialog(null,e); 
     	  }
      	
      if(b1.getText()=="SAVE")
      {
      	String cname,caddress,cmobile;
      	int cid;
      	try
      	{
      		cid=Integer.parseInt(t1.getText());
      		cname=t2.getText();
      		caddress=t3.getText();
      		cmobile=t4.getText();
      		
      		if(cname.equals("") || caddress.equals("") || cmobile.equals(""))
      		{
      			JOptionPane.showMessageDialog(f,"Enter All Record"); 
      		}
      		else
      		{
      			if((cmobile.length())==10)
      			{
      				ps=con.prepareStatement("insert into customerdetails values(?,?,?,?)");
      				ps.setInt(1,cid);
      				ps.setString(2,cname);
      				ps.setString(3,caddress);
      				ps.setString(4,cmobile);
      				ps.executeUpdate();
      				JOptionPane.showMessageDialog(f,"Record saved successfully");
      				int count=1;
      				String sql;
      				sql="Select * from customerdetails";
      				rs=stmt.executeQuery(sql);
      				while(rs.next())
      				{
      					count++;
      				
      				}
      				t1.setText(String.valueOf(count));
      				t1.setEditable(false);
      				t2.setText("");
      				t3.setText("");
      				t4.setText("");
      				
      				
      			}
      			else
      			{
      				JOptionPane.showMessageDialog(f,"Enter 10 digit mob number"); 
          		}
      			
      		}
      		
      	}
      
      catch(Exception e)
       {
      	
      }
  }

     
      if(ae.getSource()==b2)
      {
    	  System.out.println("Bill Details");
      }
      
      if(ae.getSource()==b3)
      {
      	new MedicineForm();
      }
      
  }

	public static void main(String[] args) {
	
     CustomerDetails as=new CustomerDetails();
	}

}


