package graphicalInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import editDistance.KNN;
import freeman.FreemanCode;
import freeman.FreemanToFic;
import freeman.ImgtoMatrix;
import neuralNetwork.Network;

public class ButtonArea extends JPanel implements ActionListener {

	private JButton reset;
	private JButton toMatrix;
	private JButton knn;
	private JTextArea number;
	private JTextArea result;
	
	public ButtonArea(){
		super();
		this.setPreferredSize(new Dimension(200, 100));
		reset = new JButton("reset");
		reset.addActionListener(this);
		this.add(reset, BorderLayout.CENTER);
		
		toMatrix = new JButton("To Matrix");
		toMatrix.addActionListener(this);
		this.add(toMatrix, BorderLayout.SOUTH);
		
		knn = new JButton("KNN");
		knn.addActionListener(this);
		this.add(knn, BorderLayout.WEST);
		
		number = new JTextArea(1,10);
		number.setEditable(true);
		this.add(number, BorderLayout.EAST);
		
		result = new JTextArea(1, 10);
		result.setEditable(false);
		this.add(result, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(reset)){
			Constant.DRAW.reset();
			number.setText("");
		
		}
		if(e.getSource().equals(toMatrix)){
			
			int [][] mat = ImgtoMatrix.toMatrix(Constant.DRAW.getImg());
			String f = FreemanCode.calcCodeFreeman(mat);
			if (number.getText() != null){
				int n = Integer.parseInt(number.getText());
				Constant.FCODE = new FreemanCode(f, n);
				if (Constant.FCODE != null){
					FreemanToFic.Write(Constant.FCODE);
					Constant.DRAW.reset();
				}
			}
			
		}
		
		if (e.getSource().equals(knn)){
			
			int [][] mat = ImgtoMatrix.toMatrix(Constant.DRAW.getImg());
			String f = FreemanCode.calcCodeFreeman(mat);
			int number = KNN.Knn(Constant.TDATA.data, f, 3);
			result.setText(String.valueOf(number));
			
			Network nn = new Network(8);
			nn.classify(ImgtoMatrix.toMatrix(Constant.DRAW.getImg()));
			System.out.println(nn.getOutput());
		}
		
	}
	
}
