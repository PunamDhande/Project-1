package medicalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;

class MedicineReport extends JFrame 
{
    JButton b1,b2;
    JLabel l,l1;
    JTextField t1;
    
    JFrame f;
    
    
    Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement ps;
    
  
  MedicineReport()
   {
	  f=new JFrame();
	  f.setVisible(true);
      f.setLayout(null);
      
      JTable table;
      DefaultTableModel model = new DefaultTableModel();
      DefaultTableModel model1 = new DefaultTableModel();
      
      String[] columnNames = {"mname","type","price","mfgdate","expdate"};

/*String[] cn= {"billno","cname","mname","quantity","date","price","total"};*/
       l=new JLabel("Medicine Report");
       
       l1=new JLabel("Medicine Name");
       
       t1=new JTextField(10);
       
       b1=new JButton("View Medicines");
       
       b2=new JButton("Search");
       
       

        l.setBounds(200,30,150,30);
        
        l.setForeground(Color.RED);
        l.setFont(new Font("serif",Font.BOLD,17));
        l1.setBounds(100,100,150,30);        t1.setBounds(220,100,150,30);
               
        b1.setBounds(100,150,150,30);
        b2.setBounds(300,150,80,30);
        
        
     
        f.add(l1);  f.add(t1);    f.add(b1);
        f.add(l);f.add(b2);
       
        
        
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.WHITE);
       /* b3.setBackground(Color.GREEN);
        b3.setForeground(Color.WHITE);
        l.setForeground(Color.RED);*/
        l.setFont(new Font("serif",Font.BOLD,17));
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Times New Roman",Font.BOLD,15));
        
        f.setTitle("MEDICAL STORE BILLING SYSTEM");
        f.setSize(600,600);
       
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.PINK);
        
        model.setColumnIdentifiers(columnNames);
        
        
        table = new JTable();
		table.setModel(model); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVisible(true);
		scroll.setBounds(70,210,400,150);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(scroll);
		
		
		// view button
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int mprice;
			      String name= "";
			      String mtype= "";
			      String mdate = "";
			      String edate = "";
		      
		      while(model.getRowCount()>0)
				{
					model.removeRow(0);
				}


		try
		{ 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:1433/test?serverTimezone=UTC","root","");
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from medicine1");
		int i =0;
		while(rs.next())
		{
		name= rs.getString("mname");
		mtype= rs.getString("type");
		mprice= rs.getInt("price");
		mdate = rs.getString("mfgdate");
		edate=rs.getString("expdate");
		/*gender = rs.getString("gender");
		year = rs.getInt("year");
		dept = rs.getString("dept");
		sem = rs.getInt("sem");*/


		model.addRow(new Object[]{name,mtype,mprice,mdate,edate});
		i++; 
		}
		if(i <1)
		{
		JOptionPane.showMessageDialog(null, "No Record Found","Error",
		JOptionPane.ERROR_MESSAGE);
		}

		}
		catch(Exception ex)
		{
		JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
		JOptionPane.ERROR_MESSAGE);

		}
		
					
	 }
});
		
        
   }
  public static void main(String args[]) {
	  MedicineReport r=new MedicineReport();
	  r.getAccessibleContext();
	  
  }
}

