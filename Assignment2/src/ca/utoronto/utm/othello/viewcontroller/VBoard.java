package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import javafx.animation.FadeTransition;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
/*
 * this view displays the board
 */
public class VBoard extends Label implements Observer {

	private static Othello othello;
	private GridPane grid;
	public String p1Colour = "-fx-background-color: #000000; ";
	public String p2Colour = "-fx-background-color: #FFFFFF; ";

	public VBoard(Othello othello, GridPane grid) {
		VBoard.othello = othello;
		this.grid = grid;
	}

	@Override
	public void update(Observable o) {
		Othello ot = (Othello) o;
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				Button button = new Button();
				for (Node node : this.grid.getChildren()) {
					if (GridPane.getColumnIndex(node) == col) {
						if (GridPane.getRowIndex(node) == row) {
							button = (Button) node;
							if (ot.getToken(row, col) == OthelloBoard.P1) {
								if (VBoard.othello.getToken(row, col)==OthelloBoard.P2) {
									FadeTransition fadeOut = new FadeTransition(Duration.millis(2000),button);
									fadeOut.setFromValue(1.0);
									fadeOut.setToValue(0.1);
									fadeOut.setCycleCount(2);
									fadeOut.setAutoReverse(true);
									fadeOut.play();
									}
								button.setStyle(p1Colour);
							}
							else if (ot.getToken(row, col) == OthelloBoard.P2) {
								if (VBoard.othello.getToken(row, col)==OthelloBoard.P1) {
									FadeTransition fadeOut = new FadeTransition(Duration.millis(2000),button);
									fadeOut.setFromValue(2.0);
									fadeOut.setToValue(0.1);
									fadeOut.setCycleCount(2);
									fadeOut.setAutoReverse(true);
									fadeOut.play();
									}
								button.setStyle(p2Colour);
							}
							button.setText("");
							button.setPrefSize(40, 40);
							button.setOnAction(new ButtonPressEventHandler(row, col, ot));
						}
					}
				}
			}
		}
		VBoard.othello = ot.copy();
	}

}
