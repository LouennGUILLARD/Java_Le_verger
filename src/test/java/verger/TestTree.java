package verger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import verger.model.Fruit;
import verger.model.Tree;

public class TestTree {
	
// test V1
	@Test
	void testTreeIsNotEmpty() {
		//act
		Tree treeYellow = new Tree(Fruit.YELLOW);
		//arrange
		boolean treeIsEmpty = treeYellow.treeIsEmpty();
		//assert
		assertFalse(treeIsEmpty);
	}
	
	@Test
	void testTreeIsEmpty() {
		//act
		Tree treeYellow = new Tree(Fruit.YELLOW,0);
		//arrange
		boolean treeIsEmpty = treeYellow.treeIsEmpty();
		//assert
		assertTrue(treeIsEmpty);
	}
	
	@Test
	void testTreeIsYellow() {
		//act
		Tree treeYellow = new Tree(Fruit.YELLOW);
		//arrange
		String color = treeYellow.getColor();
		//assert
		assertEquals("Yellow",color);
	}
	
	@Test
	void testTreeIsBlue() {
		//act
		Tree treeBlue = new Tree(Fruit.BLUE);
		//arrange
		String color = treeBlue.getColor();
		//assert
		assertEquals("Blue",color);
	}
	
	@Test
	void testTreeIsRed() {
		//act
		Tree treeRed = new Tree(Fruit.RED);
		//arrange
		String color = treeRed.getColor();
		//assert
		assertEquals("Red",color);
	}
	
	@Test
	void testTreeIsGreen() {
		//act
		Tree treeGreen = new Tree(Fruit.GREEN);
		//arrange
		String color = treeGreen.getColor();
		//assert
		assertEquals("Green",color);
	}
	
	
}