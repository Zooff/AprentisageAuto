package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PrincipalPanel extends JPanel{
	
	private DrawArea Drawzone;
	private ButtonArea buttonarea;
	
	public PrincipalPanel(){
		
		super();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(700, 500));
		
		Drawzone = new DrawArea();
		this.add(Drawzone, BorderLayout.CENTER);
		
		buttonarea = new ButtonArea();
		this.add(buttonarea, BorderLayout.EAST);
		
		
		
	}

}
