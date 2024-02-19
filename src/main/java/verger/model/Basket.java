package verger.model;

public class Basket {
	private Fruit color;
	private int numberFruit;
	
	public Basket (Fruit color) {
		this.color = color;
		this.numberFruit = 0;
	}
	
	public Basket (Fruit color,int numberFruit) {
		this.color = color;
		this.numberFruit = numberFruit;
	}
	
	public int numberFruitInBasket() {
		return this.numberFruit;
	}
	
	public void addNumberBasket() {
		if (!this.basketIsFull()){
			this.numberFruit = numberFruit+1;
		}
		
	}
	
	public String getColor() {
		return color.getColor();
	}
	
	public boolean basketIsFull() {
		return numberFruitInBasket()==10;
	}
	
	public boolean basketIsEmpty() {
		return numberFruitInBasket()==0;
	}
	
}
