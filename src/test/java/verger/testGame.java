package verger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import verger.model.Fruit;
import verger.model.Game;
import verger.model.Tree;

public class testGame {
	
	@Test
	void testGetRound() {
		//Act 
		Tree treeYellow = new Tree(Fruit.YELLOW);
		Tree treeBlue = new Tree(Fruit.BLUE);
		Tree treeGreen = new Tree(Fruit.GREEN);
		Tree treeRed = new Tree(Fruit.RED);
		Game courrantGame = new Game(treeYellow,treeBlue,treeGreen,treeRed);
		//Arrange
		int numberRound = courrantGame.getRound();
		//Assert
		assertEquals(0,numberRound);
	}
	
	@Test
	void testSetRound() {
		//Act 
		Tree treeYellow = new Tree(Fruit.YELLOW);
		Tree treeBlue = new Tree(Fruit.BLUE);
		Tree treeGreen = new Tree(Fruit.GREEN);
		Tree treeRed = new Tree(Fruit.RED);
		Game courrantGame = new Game(treeYellow,treeBlue,treeGreen,treeRed);
		//Arrange
		courrantGame.setRound();
		int numberRound = courrantGame.getRound();
		//Assert
		assertEquals(1,numberRound);
	}
	
	@Test
	void testSetRoundButAllTreeIsEmpty() {
		//Act 
		Tree treeYellow = new Tree(Fruit.YELLOW,0);
		Tree treeBlue = new Tree(Fruit.BLUE,0);
		Tree treeGreen = new Tree(Fruit.GREEN,0);
		Tree treeRed = new Tree(Fruit.RED,0);
		Game courrantGame = new Game(treeYellow,treeBlue,treeGreen,treeRed);
		//Arrange
		courrantGame.setRound();
		int numberRound = courrantGame.getRound();
		//Assert
		assertEquals(0,numberRound);
	}
}
