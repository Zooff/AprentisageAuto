package graphicalInterface;

import java.awt.Panel;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	private PrincipalPanel pan;
	private MenuBar bar;
	
	public MainWindow(){
		this.setTitle("AA Project");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		pan = new PrincipalPanel();
		this.setContentPane(pan);
		
		bar = new MenuBar();
		this.setJMenuBar(bar);
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

}
