package graphicalInterface;

import editDistance.KNN;
import freeman.FreemanCode;
import freeman.TrainingData;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TrainingData train = new TrainingData();
		train.Load("resources/test.txt");
		KNN.Knn(train.data, train.data.get(0).getFreeman(), 1);
		//System.out.println(train.data);
		MainWindow main = new MainWindow();
	}

}
