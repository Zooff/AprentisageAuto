package graphicalInterface;

import static javax.swing.BorderFactory.createEmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class DrawArea extends JPanel {
	
	private Drawing draw;
	
	public DrawArea(){
		super();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(300, 300));
		
		Border outset = createEmptyBorder(0,3,3,3);
		TitledBorder inset = new TitledBorder(null,"Draw", TitledBorder.CENTER, TitledBorder.CENTER);
		
		inset.setTitleJustification(TitledBorder.CENTER);
		
		this.setBorder(new CompoundBorder(outset,inset));
		
		Constant.DRAW = new Drawing();
		this.add(Constant.DRAW);
	}
	
	public BufferedImage getDrawing(){
		return draw.getImg();
	}

}
