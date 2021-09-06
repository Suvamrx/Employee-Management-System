import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class login extends JFrame {
login(){
	JPanel p1=new JPanel();
	JRadioButton b1=new JRadioButton("ADMIN");
	 b1.setBounds(20,50,40,50); //setting size and position of the button
	 b1.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 employe ob=new employe();
		 }
	 });
	 
	 JRadioButton b2=new JRadioButton("Employe");
	 b2.setBounds(20, 70, 40, 50); //setting size and position of the button
	 b2.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 display1 ob1=new display1();
		 }
	 });
	 
	 p1.add(b1);
	 p1.add(b2);
	 add(p1);
	 setSize(500,150);
	 //add(b1); add(b2);
		setLocationRelativeTo(null);   //SETS THE WHOLE FRAME AT CENTRE
		setVisible(true);
		
}
	public static void main(String[] args) {
 login ob=new login();
	}

}
