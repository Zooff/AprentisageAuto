package editDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import freeman.FreemanCode;

public class KNN {
	
	public KNN() {
		
	}
	
	public static int Knn(ArrayList<FreemanCode> listCodeFreeman, String codeFreeman, int k) {
		
		int[] classTab = new int[10];
		
		for (int i = 0; i < 10; i++)
			classTab[i] = 0;
		
		//System.out.println(listCodeFreeman.toString());
		
		for (int i = 0; i < listCodeFreeman.size(); i++) {
			
			FreemanCode c = listCodeFreeman.get(i);
			c.setEditDistance(EditDistance.minDistance(c.getFreeman(), codeFreeman));
			
		}
		
		
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
		
	//	System.out.println(listCodeFreeman.toString());
		
		for (int i = 0; i < k; i++){
			int n = listCodeFreeman.get(i).getNumber();
			
			switch(n){
			case 0:
				classTab[0]++;
				break;
			case 1:
				classTab[1]++;
				break;
			case 2:
				classTab[2]++;
				break;
			case 3:
				classTab[3]++;
				break;
			case 4:
				classTab[4]++;
				break;
			case 5:
				classTab[5]++;
				break;
			case 6:
				classTab[6]++;
				break;
			case 7:
				classTab[7]++;
				break;
			case 8:
				classTab[8]++;
				break;
			case 9:
				classTab[9]++;
				break;
			default:
				break;
			}
			
			
		}
		int max = 0;
		int val = 0;
		for (int i = 0; i< 10; i++){
			if (classTab[i] > max){
				val = i;
				max = classTab[i];
			}
		//	System.err.println(classTab[i] + " ");
		}
		return val;
		
	}

}
