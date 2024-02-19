package verger.model;

public class Crow {
	private int numbreOfPiece;

	public Crow() {
		this.numbreOfPiece = 0;
	}

	public Crow(int numberOfPice) {
		this.numbreOfPiece = numberOfPice;
	}

	public int getNumbreOfPiece() {
		return numbreOfPiece;
	}

	public void setNumbreOfPiece() {
		if(!crowIsComplet()) {
			this.numbreOfPiece = numbreOfPiece+1;
		}
	}
	
	public boolean crowIsComplet() {
		return this.numbreOfPiece == 9;
	}
	
	public boolean crowIsEmpty() {
		return this.numbreOfPiece == 0;
	}
}
