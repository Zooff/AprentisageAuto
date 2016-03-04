package tests;

import java.util.ArrayList;

import editDistance.KNN;
import freeman.FreemanCode;
import graphicalInterface.Constant;

public class CrossValidation {

	ArrayList<FreemanCode> training; // 90%
	ArrayList<FreemanCode> test; // 10%

	double[] tabPourcentage;

	public CrossValidation() {
		tabPourcentage = new double[10];
		training = new ArrayList<>();
		test = new ArrayList<>();
		CalculCrossValidation(test, training, tabPourcentage);
	}

	public static void CalculCrossValidation(ArrayList<FreemanCode> test,
			ArrayList<FreemanCode> training, double[] tabPourcentage) {

		int nbTest = (int) Math.ceil((double) Constant.TDATA.data.size() / 10);
		// System.out.println(nbTest);

		int i;
		int compteur = 0;
		double pourcent = 0;

		for (i = 0; i < nbTest; i++) {
			test.add(i, Constant.TDATA.data.get(i));
			compteur++;
		}
		System.out.println(compteur);
		for (i = 0; i < Constant.TDATA.data.size() - compteur; i++) {
			training.add(i, Constant.TDATA.data.get(i + compteur));
		}

		for (i = 0; i < 10; i++) {
			int classe = KNN.Knn(training, test.get(i).getFreeman(), 3);
			System.out.println("knn " + classe);

			if (classe == test.get(i).getNumber()) {
				pourcent += 1;
			}
		}

		tabPourcentage[0] = pourcent / 10;
		System.out.println(tabPourcentage[0]);

	}

	public static void main(String[] args) {

	}

}
