package editDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import freeman.FreemanCode;

public class KNN {
	
	public KNN() {
		
	}
	
	public int Knn(ArrayList<FreemanCode> listCodeFreeman, String codeFreeman, int k) {
		
		//int[] tabEditDistance;		
		
		
		for (int i = 0; i < listCodeFreeman.size(); i++) {
			Collections.sort(listCodeFreeman, new Comparator<FreemanCode>() {

				@Override
				public int compare(FreemanCode o1, FreemanCode o2) {
					if (o1.getEditDistance() < o2.getEditDistance())
						return -1;
					if (o1.getEditDistance() > o2.getEditDistance())
						return 1;
					return 0;
				}
			});
			//tabEditDistance[i] = minDistance(listCodeFreeman.get(i), codeFreeman);
		}
		
		
		
		return 0;
		
	}
	
	public static void main(String[] args) {
	
	}

}
