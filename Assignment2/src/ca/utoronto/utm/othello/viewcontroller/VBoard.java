package ca.utoronto.utm.othello.viewcontroller;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.animation.Timeline;
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
	public String p3Colour = "-fx-background-color: #FFB266; ";
	public String p4Colour = "-fx-background-color: grey";
	private Timeline t1;
	private Timeline t2;

	public VBoard(Othello othello, GridPane grid, Timeline t1, Timeline t2) {
		VBoard.othello = othello;
		this.grid = grid;
		this.t1=t1;
		this.t2=t2;
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
							if (ot.getToken(row, col) == OthelloBoard.P2) {
								if (VBoard.othello.getToken(row, col)==OthelloBoard.P1) {
									FadeTransition fadeOut = new FadeTransition(Duration.millis(2000),button);
									fadeOut.setFromValue(3.0);
									fadeOut.setToValue(0.1);
									fadeOut.setCycleCount(2);
									fadeOut.setAutoReverse(true);
									fadeOut.play();
									}
								button.setStyle(p2Colour);
							}
							button.setText("");
							button.setPrefSize(40, 40);
							button.setOnAction(new ButtonPressEventHandler(row, col, VBoard.othello, 
									t1, t2));
							if (button.getStyle() == p3Colour) {
								button.setStyle(p4Colour);
							}
						}
					}
				}
			}
		}
		VBoard.othello = ot.copy();
	}

}
