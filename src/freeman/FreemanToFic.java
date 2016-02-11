package freeman;

import java.io.File;
import java.io.FileWriter;

public class FreemanToFic {
	
	public static void Write(FreemanCode code){
		FileWriter f = null;
		try {
			f = new FileWriter(new File("resources/test.txt"), true);
			
			f.write(code.format());		
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if (f != null)
					f.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
