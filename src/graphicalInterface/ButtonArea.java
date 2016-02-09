package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeman.ImgtoMatrix;

public class ButtonArea extends JPanel implements ActionListener {

	private JButton reset;
	private JButton toMatrix;
	
	public ButtonArea(){
		super();
		this.setPreferredSize(new Dimension(80, 100));
		reset = new JButton("reset");
		reset.addActionListener(this);
		this.add(reset, BorderLayout.CENTER);
		
		toMatrix = new JButton("To Matrix");
		toMatrix.addActionListener(this);
		this.add(toMatrix, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(reset))
			Constant.DRAW.reset();
		
		if(e.getSource().equals(toMatrix)){
			ImgtoMatrix.toMatrix(Constant.DRAW.getImg());
		}
		
	}
	
}
