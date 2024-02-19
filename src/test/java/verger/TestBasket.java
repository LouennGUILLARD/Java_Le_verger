package verger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import verger.model.Basket;
import verger.model.Fruit;

public class TestBasket {
	@Test
	void testBasketEmpty() {
		//Act
		Basket basket = new Basket(Fruit.RED);
		//Arrange
		//Assert
		assertTrue(basket.basketIsEmpty());
	}
	
	@Test
	void testBasketIsNotEmpty() {
		//Act
		Basket basket = new Basket(Fruit.RED,1);
		//Arrange
		//Assert
		assertFalse(basket.basketIsEmpty());
	}
	
	@Test
	void testBasketFull() {
		//Act
		Basket basket = new Basket(Fruit.RED,10);
		//Arrange
		//Assert
		assertTrue(basket.basketIsFull());
	}
	
	@Test
	void testBasketIsNotFull() {
		//Act
		Basket basket = new Basket(Fruit.RED,1);
		//Arrange
		//Assert
		assertFalse(basket.basketIsFull());
	}
	
	@Test
	void testBasketIsBlue() {
		//Act
		Basket basket = new Basket(Fruit.BLUE);
		//Arrange
		String color = basket.getColor();
		//Assert
		assertEquals("Blue",color);
	}
	
	@Test
	void testBasketIsYellow() {
		//Act
		Basket basket = new Basket(Fruit.YELLOW);
		//Arrange
		String color = basket.getColor();
		//Assert
		assertEquals("Yellow",color);
	}
	
	@Test
	void testBasketIsGreen() {
		//Act
		Basket basket = new Basket(Fruit.GREEN);
		//Arrange
		String color = basket.getColor();
		//Assert
		assertEquals("Green",color);
	}
	
	@Test
	void testBasketIsRed() {
		//Act
		Basket basket = new Basket(Fruit.RED);
		//Arrange
		String color = basket.getColor();
		//Assert
		assertEquals("Red",color);
	}
	
	@Test
	void testAddFruitIntoBasket() {
		//Act
		Basket basket = new Basket(Fruit.RED,0);
		//Arrange
		basket.addNumberBasket();
		int nbFruit = basket.numberFruitInBasket();
		//Assert
		assertEquals(1,nbFruit);
	}
	
	@Test
	void testAddFruitIfBasketIsFull() {
		//Act
		Basket basket = new Basket(Fruit.RED,10);
		//Arrange
		basket.addNumberBasket();
		int nbFruit = basket.numberFruitInBasket();
		//Assert
		assertEquals(10,nbFruit);
	}
}
