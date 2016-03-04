package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		Collections.shuffle(Constant.TDATA.data, new Random(System.nanoTime()));
		CalculCrossValidation(test, training, tabPourcentage);
	}

	public void CalculCrossValidation(ArrayList<FreemanCode> test, ArrayList<FreemanCode> training,
			double[] tabPourcentage) {

		int nbTest = (int) Math.ceil((double) Constant.TDATA.data.size() / 10);
		// System.out.println(nbTest);

		int i;
		int compteur = 0;
		double pourcent = 0;

		for (int j = 0; j < 10; j++) {

			for (i = 0; i < nbTest; i++) {
				test.add(compteur, Constant.TDATA.data.get(i));
				compteur++;
			}
			System.out.println("C : " + compteur);
			for (i = 0; i < Constant.TDATA.data.size(); i++) {
				if (i > (compteur))
					training.add(i - compteur -1, Constant.TDATA.data.get(i));
				if (i < compteur - nbTest)
					training.add(i, Constant.TDATA.data.get(i));
			}

			for (i = 0; i < nbTest; i++) {
				int classe = KNN.Knn(training, test.get(i).getFreeman(), 3);
				//System.out.println("knn " + classe);

				if (classe == test.get(i).getNumber()) {
					pourcent += 1;
				}
			}

			tabPourcentage[j] = pourcent / nbTest;
			pourcent = 0;
			System.out.println(tabPourcentage[j]);
		}
		
		System.out.println(tabPourcentage.toString());
		double somme = 0;
		for (i = 0; i<tabPourcentage.length; i++)
			somme += tabPourcentage[i];
		System.out.println("Moyenne : " + somme/tabPourcentage.length);
	}

	public static void main(String[] args) {

	}

}
