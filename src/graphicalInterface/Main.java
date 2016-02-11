package graphicalInterface;

import freeman.TrainingData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TrainingData train = new TrainingData();
		train.Load("resources/test.txt");
		System.out.println(train.data);
		MainWindow main = new MainWindow();
	}

}
