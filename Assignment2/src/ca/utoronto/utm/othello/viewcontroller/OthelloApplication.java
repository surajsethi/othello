package ca.utoronto.utm.othello.viewcontroller;

import java.awt.Panel;

import ca.utoronto.utm.othello.model.*;
import ca.utoronto.utm.othello.viewcontroller.TimerHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OthelloApplication extends Application {
	// REMEMBER: To run this in the lab put
	// --module-path "/usr/share/openjfx/lib" --add-modules
	// javafx.controls,javafx.fxml
	// in the run configuration under VM arguments.
	// You can import the JavaFX.prototype launch configuration and use it as well.

	@Override
	public void start(Stage stage) throws Exception {
		// Create and hook up the Model, View and the controller

		// MODEL
		Othello othello = new Othello();
		Othello copy = othello.copy();
		// CONTROLLER
		HBox root = new HBox();
		VBox left = new VBox();
		VBox right = new VBox();
		GridPane grid = new GridPane();
		FlowPane opponentPane = new FlowPane();
		FlowPane hintPane = new FlowPane();
		
		Label p1Time = new Label("Player 1");
		Label p2Time = new Label("Player 2");

		p1Time.setFont(new Font("Arial", 30));
		p2Time.setFont(new Font("Arial", 30));
		
		Timeline timer1 = new Timeline(new KeyFrame(Duration.millis(1000), 
				new TimerHandler("Player 1", p1Time, othello)));

		Timeline timer2 = new Timeline(new KeyFrame(Duration.millis(1000), 
				new TimerHandler("Player 2", p2Time, othello)));
		
		timer1.setCycleCount(Animation.INDEFINITE);
		timer1.play();
	

		// VIEW
		VBoard vBoard = new VBoard(copy, grid, timer1, timer2);
		VBoard2 vBoard2 = new VBoard2();
		
		
		
		// VOpponentChooser vOpponentChooser = new VOpponentChooser(opponentPane, root);
		// MODEL->VIEW hookup
		othello.attach(vBoard);
		othello.attach(vBoard2);
		// othello.attach(vOpponentChooser);
		// VIEW->CONTROLLER hookup
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				Button button = new Button(" ");
				if (othello.getToken(row, col) == 'X') {
					button.setStyle("-fx-background-color: #000000; ");
				}
				if (othello.getToken(row, col) == 'O') {
					button.setStyle("-fx-background-color: #FFFFFF; ");
				}
				button.setPrefSize(40, 40);
				button.setOnAction(new ButtonPressEventHandler(row, col, othello, timer1, timer2));
				grid.addColumn(col, button);
			}
		}
		grid.setHgap(10);
		grid.setVgap(10);

		Button human = new Button("Human");
		human.setOnAction(new OpponentButtonPressEventHandler(left, grid, othello));
		Button greedy = new Button("Greedy");
		greedy.setOnAction(new OpponentButtonPressEventHandler(left, grid, othello));
		Button random = new Button("Random");
		random.setOnAction(new OpponentButtonPressEventHandler(left, grid, othello));
		
//		Button ai = new Button("AI");
//		ai.setOnAction(new HintPressEventHandler(left, grid, othello));
		Button ghint = new Button("Greedy Hint");
		ghint.setOnAction(new HintPressEventHandler(left, grid, othello));
		Button rhint = new Button("Random Hint");
		rhint.setOnAction(new HintPressEventHandler(left, grid, othello));

		Label opponent = new Label("Which opponent would you like to play against?");
		
		Label stuck = new Label("Stuck? Use a hint!");

		opponentPane.getChildren().addAll(human, greedy, random);
		opponentPane.setPrefSize(10, 10);
		opponentPane.setHgap(10);
		opponentPane.setLayoutY(100);
		//opponentPane.
		opponentPane.setLayoutX(700);
		opponentPane.setVisible(true);
		
		hintPane.getChildren().addAll(ghint, rhint);
		hintPane.setPrefSize(10, 10);
		hintPane.setHgap(10);
		hintPane.setLayoutY(100);
		//hintPane.
		hintPane.setLayoutX(700);
		hintPane.setVisible(true);
		
		left.getChildren().addAll(grid, vBoard2);
		right.getChildren().addAll(opponent, opponentPane, p1Time, p2Time, stuck, hintPane);
		root.getChildren().addAll(left, right);
		// SCENE
		Scene scene = new Scene(root, 800, 600);
		stage.setTitle("Othello");
		stage.setScene(scene);

		// LAUNCH THE GUI
		stage.show();
	}

	public static void main(String[] args) {
		// OthelloApplication view = new OthelloApplication();
		launch(args);
	}
}
