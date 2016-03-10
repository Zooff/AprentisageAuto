package graphicalInterface;

import java.util.ArrayList;

import freeman.FreemanCode;
import freeman.ImgtoMatrix;
import freeman.TrainingData;
import neuralNetwork.Network;
import tests.CrossValidation;

public class Main {

	public static void main(String[] args) {
        
		// TODO Auto-generated method stub
		
		Constant.TDATA = new TrainingData();
		Constant.TDATA.Load("resources/baseDim.txt");

		//MainWindow main = new MainWindow();
		new CrossValidation();
		
		
		
	}

}

