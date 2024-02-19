package verger.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Dice {
	YELLOW("Yellow","src/main/java/verger/img/faceDiceYellow.png"),
	BLUE("Blue","src/main/java/verger/img/faceDiceBlue.png"),
	GREEN("Green","src/main/java/verger/img/faceDiceGreen.png"),
	RED("Red","src/main/java/verger/img/faceDiceRed.png"),
	CROW("Crow","src/main/java/verger/img/crowForDice.png");
	
	
	private String color;
	private String url;
	private static final List<Dice> diceValue = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int sizeList = diceValue.size();
	private static final Random valueRandom = new Random();	
	
	Dice(String color,String url){
		this.color = color;
		this.url = url;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public static Dice randomDice() {
		return diceValue.get(valueRandom.nextInt(sizeList));
	}
}

