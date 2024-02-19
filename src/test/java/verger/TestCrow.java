package verger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import verger.model.Crow;

public class TestCrow {
	@Test
	void crowIsEmpty() {
		//Act
		Crow crow = new Crow(0);
		
		//Arrange
		boolean verification = crow.crowIsEmpty();
		
		//Assert
		assertTrue(verification);
	}
	
	@Test
	void crowIsNotEmpty() {
		//Act
		Crow crow = new Crow(1);
		
		//Arrange
		boolean verification = crow.crowIsEmpty();
		
		//Assert
		assertFalse(verification);
	}
	
	@Test
	void crowIsFull() {
		//Act
		Crow crow = new Crow(9);
		
		//Arrange
		boolean verification = crow.crowIsComplet();
		
		//Assert
		assertTrue(verification);
	}
	
	@Test
	void crowIsNotFull() {
		//Act
		Crow crow = new Crow(5);
		
		//Arrange
		boolean verification = crow.crowIsComplet();
		
		//Assert
		assertFalse(verification);
	}
	
	@Test
	void recoverNumberOfPiece() {
		//Act
		Crow crow = new Crow(9);
		
		//Arrange
		int verification = crow.getNumbreOfPiece();
		
		//Assert
		assertEquals(verification,9);
	}
	
	@Test
	void addPiece() {
		//Act
		Crow crow = new Crow(0);
		
		//Arrange
		crow.setNumbreOfPiece();
		int verification = crow.getNumbreOfPiece();
		
		//Assert
		assertEquals(verification,1);
	}
	
	@Test
	void addPieceIfCrowIsComplet() {
		//Act
		Crow crow = new Crow(9);
		
		//Arrange
		crow.setNumbreOfPiece();
		int verification = crow.getNumbreOfPiece();
		
		//Assert
		assertEquals(verification,9);
	}
}
