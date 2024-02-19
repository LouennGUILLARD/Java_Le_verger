package verger.model;

public class Tree {
	private Fruit fruit;
	private int numberFruit;
	
	public Tree (Fruit color) {
		this.fruit = color;
		this.numberFruit = 10;
	}
	
	public Tree (Fruit color,int numberFruit) {
		this.fruit = color;
		this.numberFruit = numberFruit;
	}
	
	public int numberFruitInTree() {
		return this.numberFruit;
	}
	
	public void removeNumberFruit() {
		this.numberFruit = numberFruit-1;
	}
	
	public String getColor() {
		return fruit.getColor();
	}
	
	public boolean treeIsEmpty() {
		return numberFruitInTree()==0;
	}
	
	
	
}
