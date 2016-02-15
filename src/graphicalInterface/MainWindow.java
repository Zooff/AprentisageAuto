package graphicalInterface;

import java.awt.Panel;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	private PrincipalPanel pan;
	
	public MainWindow(){
		this.setTitle("AA Project");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		pan = new PrincipalPanel();
		this.setContentPane(pan);
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

}
