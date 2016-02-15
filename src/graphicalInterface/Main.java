package graphicalInterface;

import freeman.TrainingData;

public class Main {

	public static void main(String[] args) {
        
		// TODO Auto-generated method stub
		
		Constant.TDATA = new TrainingData();
		Constant.TDATA.Load("resources/test.txt");

		MainWindow main = new MainWindow();
	}

}
