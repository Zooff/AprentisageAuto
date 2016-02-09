package freeman;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;

public class ImgtoMatrix {
	
	public static int width;
	public static int height;
	
	public static int[][] result;

	
	public static int[][] toMatrix(BufferedImage image){
		width = image.getWidth();
		height = image.getHeight();
		
		System.out.println(width + "  " + height);
		
		result = new int[height][width];
		
		for (int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if (image.getRGB(j, i) == 0)
					result[i][j] = 0;
				else
					result[i][j] = 1;
			}
		}
		
		PrintMatrix();
		return result;
	}
	
	// Using Pixel
	public static int[][] convertToArray(BufferedImage image)
	{

	    if (image == null || image.getWidth() == 0 || image.getHeight() == 0)
	        return null;

	    // This returns bytes of data starting from the top left of the bitmap
	    // image and goes down.
	    // Top to bottom. Left to right.
	    
	    
	    
	    final byte[] pixels = ((DataBufferByte) image.getRaster()
	            .getDataBuffer()).getData();

	    width = image.getWidth();
	    height = image.getHeight();

	    result = new int[height][width];

	    boolean done = false;
	    boolean alreadyWentToNextByte = false;
	    int byteIndex = 0;
	    int row = 0;
	    int col = 0;
	    int numBits = 0;
	    byte currentByte = pixels[byteIndex];
	    while (!done)
	    {
	        alreadyWentToNextByte = false;

	        result[row][col] = (currentByte & 0x80) >> 7;
	        currentByte = (byte) (((int) currentByte) << 1);
	        numBits++;

	        if ((row == height - 1) && (col == width - 1))
	        {
	            done = true;
	        }
	        else
	        {
	            col++;

	            if (numBits == 8)
	            {
	                currentByte = pixels[++byteIndex];
	                numBits = 0;
	                alreadyWentToNextByte = true;
	            }

	            if (col == width)
	            {
	                row++;
	                col = 0;

	                if (!alreadyWentToNextByte)
	                {
	                    currentByte = pixels[++byteIndex];
	                    numBits = 0;
	                }
	            }
	        }
	    }
	    PrintMatrix();
	    return result;
	}
	
	
	public static void PrintMatrix(){
		
		for(int i=0; i< height; i++){
			for(int j = 0; j < width; j++){
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
