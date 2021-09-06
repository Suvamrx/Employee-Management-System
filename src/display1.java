import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class display1 extends JFrame{
display1(){
		
		JTextArea a1=new JTextArea(20,20);
		a1.setEditable(false);
		JScrollPane sp1=new JScrollPane(a1);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(sp1);
		
	  setSize(500,150);
		setLocationRelativeTo(null);   //SETS THE WHOLE FRAME AT CENTRE
		setVisible(true);
		 
		/*addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					employe h= new employe();
					dispose();
				}
			});
		*/
		StringBuffer sb=new StringBuffer();
		 try{  
			 Class.forName("com.mysql.jdbc.Driver");  
			 Connection con=DriverManager.getConnection(  
			 "jdbc:mysql://localhost:3306/employe","root","root");  
			 Statement stmt=con.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from emp order by id");  
			 sb.append("ID"+"\t"+"Name"+"\t"+"Age"+"\n");
			 while(rs.next()) 
				sb.append(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\n");
			 con.close();
			 a1.setText(sb.toString());
			 }catch(Exception y){ 
				 JOptionPane.showMessageDialog(new JDialog()," "+y);
		 dispose();
			 }
		
	}

	public static void main(String[] args) {
      display1 ob=new display1();
	}

}
