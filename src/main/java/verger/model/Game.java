package verger.model;

import java.util.List;

import javafx.scene.shape.Circle;

public class Game {

	private int round;

	private Tree treeYellow;
	private Tree treeBlue;
	private Tree treeGreen;
	private Tree treeRed;

	public Game(Tree treeYellow, Tree treeBlue, Tree treeGreen, Tree treeRed) {
		this.round = 0;
		this.treeYellow = treeYellow;
		this.treeBlue = treeBlue;
		this.treeGreen = treeGreen;
		this.treeRed = treeRed;
	}

	public void setRound() {
		if(!treeYellow.treeIsEmpty() && !treeBlue.treeIsEmpty() && !treeGreen.treeIsEmpty() && !treeRed.treeIsEmpty()) {
			this.round++;
		}
		
	}

	public Dice launchDice() {
		Dice faceAfterLaunch;
		setRound();
		faceAfterLaunch = Dice.randomDice();
		return faceAfterLaunch;
	}

	public int getRound() {
		return this.round;
	}

	public void decrementFruit(Dice faceDice, List<Circle> redFruit, List<Circle> blueFruit, List<Circle> greenFruit,
			List<Circle> yellowFruit) {
		if ((faceDice.getColor().equals("Yellow")) && (treeYellow.numberFruitInTree() > 0)) {
			treeYellow.removeNumberFruit();
			yellowFruit.remove(treeYellow.numberFruitInTree());

		} else if ((faceDice.getColor().equals("Green")) && (treeGreen.numberFruitInTree() > 0)) {
			treeGreen.removeNumberFruit();
			greenFruit.remove(treeGreen.numberFruitInTree());
		} else if ((faceDice.getColor().equals("Red")) && (treeRed.numberFruitInTree() > 0)) {
			treeRed.removeNumberFruit();
			redFruit.remove(treeRed.numberFruitInTree());
		} else if ((faceDice.getColor().equals("Blue")) && (treeBlue.numberFruitInTree() > 0)) {
			treeBlue.removeNumberFruit();
			blueFruit.remove(treeBlue.numberFruitInTree());
		}
	}
}
