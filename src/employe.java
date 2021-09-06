/*Problem Statement: This project is a simple Employee Management System. In this project you will be learning how to add new employee to the database, how to generate a 5-digit unique employee ID for each employee, how to enroll employee in the given department. Also, you will be implementing the following operations enroll, view employee details, position, salary and department status, etc. The status will
 *show all the details of the employee including name, id and age.
 *Author: Suvam Pattnaik , sec-j , 3rd Sem CSE 
 * Date: 16/02/2021
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import java.sql.*;

public class employe extends JFrame{

	employe(){
		 JFrame j=new JFrame("Employe Database"); // Frame with name
		  // TextFields to enter inputs 
		 JPanel p1=new JPanel();
		 JTextField t0=new JTextField("Enter your Registration number",16);// for Entering  Registration Id
		 t0.setBounds(30, 10,30, 40); //setting size and position of the text fields 
		 JTextField t1=new JTextField("Enter your name",16);// for Entering Name
		 t1.setBounds(30, 30,50, 60);//setting size and position of the text fields
		 JTextField t2=new JTextField("Enter your age",16);// for Entering Age
		t2.setBounds(30, 50, 70, 80);	 //setting size and position of the text fields
		 JButton b1=new JButton("Save"); // Button for executing the insert operation
		 b1.setBounds(50, 80, 40, 40); //setting size and position of the button
			 b1.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					
					 String s1=t0.getText();
					 String s2=t1.getText();
					 String s3=t2.getText();					 
					// Esatblishing Connection and executing operatioin
					 try{                                          
						  Class.forName("com.mysql.jdbc.Driver");  
						  Connection con=DriverManager.getConnection(  
						  "jdbc:mysql://localhost:3306/employe","root","root"); 
						  String sql="Insert into emp ( id,name,age) value (?,?,?)";
				           PreparedStatement st=con.prepareStatement(sql);
				           st.setString(1,s1);
				           st.setString(2,s2);
				           st.setString(3,s3);
						  st.executeUpdate();
						  System.out.println("Data Saved Successfully.......");
						  con.close();  
						  }catch(Exception y){ 
							  
							  JOptionPane.showMessageDialog(null, "Data Saved Successfully.....");
							  
							  }  

					 setVisible(true);
					 dispose();
					 
				 }
			 });
			 
			 JButton b2=new JButton("Display Details"); // Button for executing the display operation
			 b2.setBounds(50, 80, 40, 40); //setting size and position of the button
				 b2.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 
					 
						// Esatblishing Connection and executing operatioin
						/* try{  
							 Class.forName("com.mysql.jdbc.Driver");  
							 Connection con=DriverManager.getConnection(  
							 "jdbc:mysql://localhost:3306/employe","root","root");  
							 Statement stmt=con.createStatement();  
							 ResultSet rs=stmt.executeQuery("select * from emp");  
							 System.out.println("displaying.....");
							 while(rs.next())  
							 System.out.println("Registration ID: "+rs.getInt(1)+"  Name: "+rs.getString(2)+"  Age: "+rs.getString(3));  
							 con.close();  
							 }catch(Exception y){ 
								 JOptionPane.showMessageDialog(null, "Displaying Data..............");
								 System.out.println(y);}
						 
						 setVisible(true);
						 dispose();
					*/
						 display ob=new display();
					 }
						 
				 });
				 JButton b3=new JButton("Delete"); // Button for executing the delete operation
				 b3.setBounds(50, 80, 40, 40); //setting size and position of the button
					 b3.addActionListener(new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
							 String s1=t0.getText();
							 String s2=t1.getText();
							 String s3=t2.getText();					 
							// Esatblishing Connection and executing operatioin
							 try{  
								  Class.forName("com.mysql.jdbc.Driver");  
								  Connection con=DriverManager.getConnection(  
								  "jdbc:mysql://localhost:3306/employe","root","root");  
								  String sql="Delete from emp Where id=?";
						           PreparedStatement st=con.prepareStatement(sql);
						           st.setString(1,s1);						           
								  st.executeUpdate();
								  System.out.println("Deleted successfully...");
								  con.close();  
								  }catch(Exception k){ 
									  
									  JOptionPane.showMessageDialog(null, "Data Deleted");
									  
									    
									  
									  }  
							 setVisible(true);
							 dispose();
							
						 }
					 });
					 JButton b4=new JButton("Update"); // Button for executing the update operation
					 b4.setBounds(50, 80, 40, 40);//setting size and position of the button
						 b4.addActionListener(new ActionListener() {
							 public void actionPerformed(ActionEvent e) {
								 String s1=t0.getText();
								 String s2=t1.getText();
								 String s3=t2.getText();		
								// Esatblishing Connection and executing operatioin
								 try{  
									  Class.forName("com.mysql.jdbc.Driver");  
									  Connection con=DriverManager.getConnection(  
									  "jdbc:mysql://localhost:3306/employe","root","root");  
									  String sql="Update emp set name=?,age=? WHERE id=? ";
							           PreparedStatement st=con.prepareStatement(sql);
							           st.setString(1,s2);	
							           st.setString(2, s3);
							           st.setString(3, s1);
									  st.executeUpdate();
									 System.out.println("Updated Successfully.....");
									 ResultSet rs=st.executeQuery("select * from emp");  
									 while(rs.next())  
									 System.out.println("Registration ID: "+rs.getInt(1)+"  Name: "+rs.getString(2)+"  Age: "+rs.getString(3));  
									 con.close();   
									  }catch(Exception k){ 
										  JOptionPane.showMessageDialog(null, "Data Updated");
										  
										  System.out.println(k);
										  
										  
										  }  
								 setVisible(true);
								 dispose();
								
							 }
						 });
						 // Adding the components to the frame
			 p1.add(t0);
			 p1.add(t1);
			 p1.add(t2);
			 JPanel p2=new JPanel();
			 p2.add(b1);
			 p2.add(b2);
			 p2.add(b3);
			 p2.add(b4);
			 j.add(p1);
			 j.add(p2);
			 j.setLayout(new FlowLayout(FlowLayout.CENTER)); // setting the layout 
			 j.setSize(600, 150);// setting size of the frame
			 j.setVisible(true);
			 j.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 }
		public static void main(String[] args) {
	  employe ob=new employe();
	  
		}

	}
