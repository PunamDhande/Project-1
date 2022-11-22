
//……………………………………………………..Admin Login……………………………………………………………………//
package medicalsystem;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class AdminLogin extends Frame implements ActionListener
{
  JButton b1,b2;
  JLabel l,l1,l2;
  JTextField t1;
  JPasswordField t2;
  JFrame f;
  
  String sql;
  Connection conn;
  PreparedStatement pstat=null;
  Statement stmt = null;
  ResultSet rs;
AdminLogin()
 {
	  f=new JFrame();
	  f.setVisible(true);
    f.setLayout(null);
     l=new JLabel("Admin Login");
     
     l1=new JLabel("Username");
     l2=new JLabel("Passward");
     t1=new JTextField(10);
     t2=new JPasswordField(10);
     b1=new JButton("LOGIN");
     b2=new JButton("Exit");
     
     

      l.setBounds(200,30,100,30);
      Color c4=new Color(255,0,128);
      l.setForeground(c4);
      l.setFont(new Font("serif",Font.BOLD,17));
      l1.setBounds(100,100,100,30);        t1.setBounds(200,100,150,30);
      l2.setBounds(100,150,100,30);        t2.setBounds(200,150,150,30);
      b1.setBounds(200,200,80,30);
      b2.setBounds(300,200,80,30);
      
   
      f.add(l1);  f.add(t1);  f.add(l2);  f.add(t2); f.add(b1);
      f.add(l);f.add(b2);
      
      
      ImageIcon bgimg=new ImageIcon("F:\\msbs\\Medical-Background-download-free.png");
		Image img=bgimg.getImage();
		Image tempi=img.getScaledInstance(600,600,Image.SCALE_SMOOTH);
		bgimg=new ImageIcon(tempi);
		JLabel bg=new JLabel("",bgimg,JLabel.CENTER);
		bg.setBackground(new Color(38,166,00));
		bg.setBounds(0,0,600,600);
		f.add(bg);
      b1.setBackground(Color.GREEN);
      b1.setForeground(Color.WHITE);
      b2.setBackground(Color.GREEN);
      b2.setForeground(Color.WHITE);
      l.setForeground(Color.RED);
      l.setFont(new Font("serif",Font.BOLD,17));
      l1.setForeground(Color.MAGENTA);
      l1.setFont(new Font("Times New Roman",Font.BOLD,15));
      l2.setForeground(Color.MAGENTA);
      l2.setFont(new Font("Times New Roman",Font.BOLD,15));
      f.setTitle("Login Page");
      f.setSize(600,600);
     
      f.setResizable(false);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.getContentPane().setBackground(Color.LIGHT_GRAY);
      b1.addActionListener(this);
      b2.addActionListener(this);
      
 }
@SuppressWarnings("deprecation")

public void actionPerformed(ActionEvent e)
  {
	  
	  if(e.getSource()==b1) {
		  
		  
	         String user,pass;
	         user=t1.getText();
	         pass=t2.getText();
	                   if(user.equals("admin") && pass.equals("admin123"))
	                          {
			               System.out.println("First Page");
	                	  
	                	  f.setVisible(false);
	                           }
	                   else
	                     {
		             JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
			t1.setText("");
			t2.setText("");
	                    }
		  }
                 if(e.getSource()==b2)
                 {
              	   System.exit(0);
                 }
   }

public static void main(String args[])
{
   AdminLogin al=new AdminLogin();
 }
}

