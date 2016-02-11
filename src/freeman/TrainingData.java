package freeman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainingData {
	
	public ArrayList<FreemanCode> data;
	
	public TrainingData(){
		data = new ArrayList<FreemanCode>();
	}
	
	public void Load(String trainingFile){
		
		String line;
		
		try {
			
			System.out.println("Start Load");
			BufferedReader read = new BufferedReader(new FileReader( new File(trainingFile)));
			
			while ((line = read.readLine()) != null){
				Scanner scan = new Scanner(line);
				scan.useDelimiter(" ");
				scan.next();
				scan.next();
				String freeman = scan.next();
				scan.next();
				scan.next();
				scan.next();
				int number = scan.nextInt();
				data.add(new FreemanCode(freeman, number));
			}
			
			read.close();
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
