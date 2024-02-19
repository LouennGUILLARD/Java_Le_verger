package verger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import verger.model.Basket;
import verger.model.Crow;
import verger.model.Dice;
import verger.model.Fruit;
import verger.model.Game;
import verger.model.Tree;

public class Main extends Application {
	
	//image constant
	private String signImage = "src/main/java/verger/img/sign.png";
	private String chestImage = "src/main/java/verger/img/chest.png";
	
	//Creation Tree
	private Tree treeYellow = new Tree(Fruit.YELLOW);
	private Tree treeBlue = new Tree(Fruit.BLUE);
	private Tree treeGreen = new Tree(Fruit.GREEN);
	private Tree treeRed = new Tree(Fruit.RED);
	
	//Creation Crow
	private Crow crow = new Crow();
	
	//Creation Basket
	private Basket redBasqket = new Basket(Fruit.RED);
	private Basket yellowBasqket = new Basket(Fruit.YELLOW);
	private Basket greenBasqket = new Basket(Fruit.GREEN);
	private Basket blueBasqket = new Basket(Fruit.BLUE);
	
	//Creation layout for Crow
	private GridPane imgForCrow = new GridPane();
	private List<ImageView> listImageForCrow = createCrowGridPane();
	
	
	//Creation list of Fruit
	private List<Circle> redFruit = new ArrayList<>(creationFruit(Paint.valueOf(Fruit.RED.toString())));
	private List<Circle> blueFruit = new ArrayList<>(creationFruit(Paint.valueOf(Fruit.BLUE.toString())));
	private List<Circle> greenFruit = new ArrayList<>(creationFruit(Paint.valueOf(Fruit.GREEN.toString())));
	private List<Circle> yellowFruit = new ArrayList<>(creationFruit(Paint.valueOf(Fruit.YELLOW.toString())));
	
	//Creation label score
	private Label scoreBasket1 = new Label();
	private Label scoreBasket2 = new Label();
	private Label scoreBasket3 = new Label();
	private Label scoreBasket4 = new Label();
	
	//Other creation for interface
	private Game courrantGame = new Game(treeYellow, treeBlue, treeGreen, treeRed);
	private Label lblRoundNumber = new Label("");
	private Button btnQuit = new Button("Quit");
	

	public void start(Stage primaryStage) throws Exception {

		BorderPane container = new BorderPane();
		primaryStage.setTitle("Verger Game");

		// creation pane for game
		Pane pane = new Pane();
		File imgBackgroud = new File("src/main/java/verger/img/image_fond_SAE_S2.02.png");
		Button btnLaunch = new Button("Launch");

		GridPane fruitRedTree = new GridPane();
		creationTree(fruitRedTree, 22, redFruit);

		GridPane fruitBlueTree = new GridPane();
		creationTree(fruitBlueTree, 275, blueFruit);

		GridPane fruitGreenTree = new GridPane();
		creationTree(fruitGreenTree, 521, greenFruit);

		GridPane fruitYellowTree = new GridPane();
		creationTree(fruitYellowTree, 756, yellowFruit);

		btnLaunch.setLayoutX(362);
		btnLaunch.setLayoutY(57);

		ImageView backgroundImageView = createImage(imgBackgroud, 0, 0, 960, 540);

		lblRoundNumber.setLayoutX(338);
		lblRoundNumber.setLayoutY(27);
		lblRoundNumber.setFont(new Font(20));
		imgForCrow.setLayoutX(691);
		imgForCrow.setLayoutY(30);
		imgForCrow.setHgap(0);
		imgForCrow.setVgap(0);
		pane.getChildren().addAll(backgroundImageView, btnLaunch, fruitBlueTree, fruitGreenTree, fruitRedTree,
				fruitYellowTree, lblRoundNumber, imgForCrow);
		creationBasketAndSign(pane);
		
		

		// Creation label for score
		scoreBasket1.setLayoutX(68);
		scoreBasket1.setLayoutY(435);
		scoreBasket1.setFont(new Font(15));

		scoreBasket2.setLayoutX(312);
		scoreBasket2.setLayoutY(435);
		scoreBasket2.setFont(new Font(15));

		scoreBasket3.setLayoutX(555);
		scoreBasket3.setLayoutY(435);
		scoreBasket3.setFont(new Font(15));

		scoreBasket4.setLayoutX(799);
		scoreBasket4.setLayoutY(435);
		scoreBasket4.setFont(new Font(15));
		
		pane.getChildren().addAll(scoreBasket1, scoreBasket2, scoreBasket3, scoreBasket4);

		// interaction for Launch button
		btnLaunch.setOnAction(e -> {
			Dice faceDice;
			faceDice = courrantGame.launchDice();
			ImageView imgDiceView = createImage(new File(faceDice.getUrl()), 450, 12, 100, 100);
			pane.getChildren().add(imgDiceView);
			courrantGame.decrementFruit(faceDice, redFruit, blueFruit, greenFruit, yellowFruit);
			changeRoundNumber();

			if (faceDice.getColor().equals("Yellow")) {
				addFruitIntoTree(fruitYellowTree, yellowFruit);
				yellowBasqket.addNumberBasket();
				scoreBasket4.setText(viewScore(yellowBasqket));
				
			} else if (faceDice.getColor().equals("Green")) {
				addFruitIntoTree(fruitGreenTree, greenFruit);
				greenBasqket.addNumberBasket();
				scoreBasket3.setText(viewScore(greenBasqket));
				
			} else if (faceDice.getColor().equals("Blue")) {
				addFruitIntoTree(fruitBlueTree, blueFruit);
				blueBasqket.addNumberBasket();
				scoreBasket2.setText(viewScore(blueBasqket));
				
			} else if (faceDice.getColor().equals("Red")) {
				addFruitIntoTree(fruitRedTree, redFruit);
				redBasqket.addNumberBasket();
				scoreBasket1.setText(viewScore(redBasqket));
				
			} else if (faceDice.getColor().equals("Crow")) {
				crow.setNumbreOfPiece();
				int sizeListImgCrow = listImageForCrow.size();
				Random valueRandom = new Random();
				ImageView courrantImgCrow = listImageForCrow.get(valueRandom.nextInt(sizeListImgCrow));
				listImageForCrow.remove(courrantImgCrow);
				courrantImgCrow.setVisible(true);
			}
			if (crow.crowIsComplet()) { 
				pane.setVisible(false);
			  
				//creation pane for lose 
				Pane paneGameLose = new Pane(); 
				Label lblLoseGame = new Label("You Lose");
				ImageView imageCrowForLoseGame = createImage(new File("src/main/java/verger/img/crowfinal.png"), 10, 10, 200, 200);
				ImageView backgroundImageLoseGame = createImage(new File("src/main/java/verger/img/minecraft_end_game_lose.jpg"), 0, 0, 960, 540);
				lblLoseGame.setLayoutX(210);
				lblLoseGame.setLayoutY(50);
				btnQuit.setLayoutX(285);
				btnQuit.setLayoutY(125);
				lblLoseGame.setFont(new Font(50));
				paneGameLose.getChildren().addAll(backgroundImageLoseGame,lblLoseGame,btnQuit,imageCrowForLoseGame);
				container.setCenter(paneGameLose); 
			}
			
			if (treeBlue.treeIsEmpty() && treeGreen.treeIsEmpty() && treeRed.treeIsEmpty()
					&& treeYellow.treeIsEmpty()) {

				pane.setVisible(false);

				// creation pane for victory
				Pane paneEndGame = new Pane();
				Label lblEndGame = new Label("You Win");
				Label lblRoundOnEnd = new Label("");
				ImageView backgroundEndGameWin = createImage(imgBackgroud, 0, 0, 960, 540);
				lblEndGame.setLayoutX(391);
				lblEndGame.setLayoutY(100);
				lblRoundOnEnd.setLayoutX(430);
				lblRoundOnEnd.setLayoutY(200);
				btnQuit.setLayoutX(466);
				btnQuit.setLayoutY(175);
				lblEndGame.setFont(new Font(50));
				paneEndGame.getChildren().addAll(backgroundEndGameWin, lblEndGame, lblRoundOnEnd, btnQuit);

				lblRoundOnEnd.setText("Number of round : " + courrantGame.getRound());
				container.setCenter(paneEndGame);
			}
		});

		// interaction for quit button
		btnQuit.setOnAction(event -> primaryStage.close());

		container.setCenter(pane);
		Scene scene = new Scene(container, 960, 540);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private String viewScore(Basket basket) {
		return "Score : " + basket.numberFruitInBasket();
	}

	private void creationTree(GridPane fruitTree, int layoutx, List<Circle> fruit) {
		fruitTree.setHgap(10);
		fruitTree.setVgap(10);
		fruitTree.setLayoutX(layoutx);
		fruitTree.setLayoutY(275);
		addFruitIntoTree(fruitTree, fruit);
	}

	private void creationBasketAndSign(Pane pane) {
		ImageView basket1 = createImage(new File(chestImage), 135, 420, 85, 105);
		ImageView basket2 = createImage(new File(chestImage), 375, 420, 85, 105);
		ImageView basket3 = createImage(new File(chestImage), 620, 420, 85, 105);
		ImageView basket4 = createImage(new File(chestImage), 864, 420, 85, 105);
		ImageView sign1 = createImage(new File(signImage), 61, 427, 78, 78);
		ImageView sign2 = createImage(new File(signImage), 305, 427, 78, 78);
		ImageView sign3 = createImage(new File(signImage), 548, 427, 78, 78);
		ImageView sign4 = createImage(new File(signImage), 791, 427, 78, 78);
		pane.getChildren().addAll(basket1, basket2, basket3, basket4, sign1, sign2, sign3, sign4);
	}

	public void changeRoundNumber() {
		lblRoundNumber.setText("Round N°" + courrantGame.getRound());
	}

	public ImageView createImage(File file, int layoutX, int layoutY, int fitW, int fitH) {
		Image image = new Image(file.toURI().toString());
		ImageView imageView = new ImageView(image);
		imageView.setLayoutX(layoutX);
		imageView.setLayoutY(layoutY);
		imageView.setFitHeight(fitH);
		imageView.setFitWidth(fitW);
		return imageView;

	}

	public List<Circle> creationFruit(Paint color) {
		List<Circle> circleList = new ArrayList<>();

		int count = 0;
		while (count < 10) {
			Circle circle = new Circle(20);
			circle.setFill(color);
			circleList.add(circle);
			count++;
		}
		return circleList;
	}

	public void addFruitIntoTree(GridPane tree, List<Circle> fruit) {
		int row = 0;
		int column = 0;

		tree.getChildren().clear();

		for (Circle circle : fruit) {
			tree.add(circle, column, row);

			column++;
			if (column == 4) {
				column = 0;
				row++;
			}
		}
	}

	public List<ImageView> createCrowGridPane() {
		List<ImageView> listeImage = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				File file = new File("src/main/java/verger/img/crow/" + i + j + ".png");
				Image imageCrow = new Image(file.toURI().toString());
				ImageView imageCrowView = new ImageView(imageCrow);
				listeImage.add(imageCrowView);
				imageCrowView.setVisible(false);
				imageCrowView.setFitWidth(33.33);
				imageCrowView.setFitWidth(33.33);
				imageCrowView.setPreserveRatio(true);
				imgForCrow.add(imageCrowView, i, j);
			}
		}
		return listeImage;
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
