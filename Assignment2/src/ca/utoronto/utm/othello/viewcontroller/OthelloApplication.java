package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
		
		// CONTROLLER
		VBox root = new VBox();
		GridPane grid = new GridPane();
		//VIEW
		VBoard vBoard = new VBoard(othello, grid);
		VBoard2 vBoard2 = new VBoard2();
		// MODEL->VIEW hookup
		othello.attach(vBoard);
		othello.attach(vBoard2);
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
				button.setOnAction(new ButtonPressEventHandler(row, col, othello));
				grid.addColumn(col, button);
			}
		}
		grid.setHgap(10);
		grid.setVgap(10);
		
		root.getChildren().addAll(grid,vBoard2);
		// SCENE
		Scene scene = new Scene(root, 400, 500);
		stage.setTitle("Othello");
		stage.setScene(scene);

		// LAUNCH THE GUI
		stage.show();
	}

	public static void main(String[] args) {
		//OthelloApplication view = new OthelloApplication();
		launch(args);
	}
}
