package verger.model;

public enum Fruit {
	YELLOW("Yellow"),
	BLUE("Blue"),
	GREEN("Green"),
	RED("Red");
	
	private String color;
	
	
	Fruit(String color){
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
}
