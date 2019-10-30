package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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

		// MODEL->VIEW hookup
		
		// CONTROLLER
		// CONTROLLER->MODEL hookup
		
		//VIEW
		// VIEW->CONTROLLER hookup
		GridPane grid = new GridPane();
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				Button button = new Button(" ");
				if (othello.getToken(row, col) == 'X') {
					button.setText("X");
				}
				if (othello.getToken(row, col) == 'O') {
					button.setText("O");
				} 
				button.setPrefSize(40, 40);
				button.setOnAction(new ButtonPressEventHandler(row, col, othello));
				grid.addColumn(col, button);
			}
		}
		VBoard vBoard = new VBoard(othello, grid);
		
		// VIEW->CONTROLLER hookup
		othello.attach(vBoard);
		
		// SCENE
		Scene scene = new Scene(grid);
		stage.setTitle("Othello");
		stage.setScene(scene);

		// LAUNCH THE GUI
		stage.show();
	}

	public static void main(String[] args) {
		OthelloApplication view = new OthelloApplication();
		launch(args);
	}
}
