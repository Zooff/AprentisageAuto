package freeman;

public class FreemanCode {
	
	private String freeman;
	private int number;
	private int editDistance;
	
	public FreemanCode(String f, int n){
		freeman = f;
		number = n;
	}

	public String getFreeman() {
		return freeman;
	}

	public void setFreeman(String freeman) {
		this.freeman = freeman;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	public int getEditDistance() {
		return editDistance;
	}

	public void setEditDistance(int editDistance) {
		this.editDistance = editDistance;
	}

	public static String calcCodeFreeman(int[][] matrice) {

		String codeFreeman = "";
		int direction = 2;

		int i = 0;
		int j = 0;

		int X0, Y0; // Coord du point de depart
		int Xc, Yc; // Coord du point courant
		int Xn, Yn;

		// Determine les coord du point le plus en haut le plus à gauche
		do {
			if (j < matrice.length - 1)
				j++;
			if (j == matrice.length - 1) {
				j = 0;
				i++;
			}
		} while (matrice[i][j] == 0);
		X0 = i;
		Y0 = j;

		Xc = X0;
		Yc = Y0;

		//System.out.println("X0 = " + X0);
		//System.out.println("Y0 = " + Y0);

		do {
			direction = (direction + 6) % 8;
			//System.out.println("Direction = " + direction);
			do {
				Xn = prochainPixelX(Xc, direction);
				Yn = prochainPixelY(Yc, direction);
				direction = (direction + 1) % 8;
				//System.out.println("Xn = " + Xn);
				//System.out.println("Yn = " + Yn);
			} while (matrice[Xn][Yn] != 1);
			direction = (direction + 7) % 8; // Pour prendre la précédente direction
			codeFreeman = codeFreeman.concat(Integer.toString(direction));
			//System.out.println("Code Freeman : " + codeFreeman);
			Xc = Xn;
			Yc = Yn;
			//System.out.println("Xc = " + Xc);
			//System.out.println("Yc = " + Yc);
		} while (Xc != X0 || Yc != Y0);

		return codeFreeman;
	}
	
	private static int prochainPixelX(int Xc, int direction) {
		if (direction == 7 || direction == 0 || direction == 1)
			Xc--;
		if (direction == 3 || direction == 4 || direction == 5)
			Xc++;
		
		return Xc;
	}

	private static int prochainPixelY(int Yc, int direction) {
		if (direction == 1 || direction == 2 || direction == 3)
			Yc++;
		if (direction == 5 || direction == 6 || direction == 7)
			Yc--;
		
		return Yc;
	}

	public String format(){
		return ("Freeman < "+ freeman + " > Class : " + number + "\n");
	}

}
