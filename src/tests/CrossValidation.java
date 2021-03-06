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

	public CrossValidation(double val) {
		int taille = val == 0.1 ? 10 : 4;
		tabPourcentage = new double[taille];
		training = new ArrayList<>();
		test = new ArrayList<>();
		Collections.shuffle(Constant.TDATA.data, new Random(System.nanoTime()));
		CalculCrossValidation(val);
	}

	public void CalculCrossValidation(double val) {

		int tailleEff = (int)(Constant.TDATA.data.size() * val);
		int nbTest = val == 0.1 ? 10 : 4;
		System.out.println("nBT : "  +nbTest);

		int i;
		int compteur = 0;
		double pourcent = 0;

		for (int j = 0; j < nbTest - 1; j++) {
			System.out.println("C : " + compteur);
			for (i = 0; i < Constant.TDATA.data.size(); i++) {
				if (i >= compteur && i < compteur + tailleEff){
					test.add(Constant.TDATA.data.get(i));
				}
				else {
					training.add(Constant.TDATA.data.get(i));
				}
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
			compteur += tailleEff;
			training.clear();
			test.clear();
		}
		
		// Le dernier test
		for (i = 0; i < Constant.TDATA.data.size(); i++){
			if (i >= compteur && i < compteur + nbTest){
				test.add(Constant.TDATA.data.get(i));
			}
			else {
				training.add(Constant.TDATA.data.get(i));
			}
		}
		
		for(i = 0; i < test.size(); i++){
			int classe = KNN.Knn(training, test.get(i).getFreeman(), 3);
			if (classe == test.get(i).getNumber()) {
				pourcent += 1;
			}
		}
		
		
		tabPourcentage[nbTest - 1] = pourcent/test.size();
		
		double somme = 0;
		for (i = 0; i<tabPourcentage.length; i++)
			somme += tabPourcentage[i];
		System.out.println("Moyenne : " + somme/tabPourcentage.length);
	}

}
