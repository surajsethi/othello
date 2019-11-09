package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.othello.model.PlayerRandom;
import ca.utoronto.utm.othello.model.Move;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HintPressEventHandler implements EventHandler<ActionEvent>  {
	private VBox pane;
	private Button b;
	private static Label label;
	private GridPane grid;
	public String p1Colour = "-fx-background-color: #000000; ";
	public String p2Colour = "-fx-background-color: #FFFFFF; ";
	public String p3Colour = "-fx-background-color: #FFB266; ";
	private Othello othello;
	
	public HintPressEventHandler(VBox left, GridPane grid, Othello othello) {
		this.pane = left;
		HintPressEventHandler.label = new Label();
		this.pane.getChildren().addAll(label);
		this.grid = grid;
		this.othello = othello;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.b = ((Button) (event.getSource()));
		
		PlayerGreedy p1 = new PlayerGreedy(this.othello, OthelloBoard.P1);
		PlayerRandom p2 = new PlayerRandom(this.othello, OthelloBoard.P1);
		if (this.othello.getWhosTurn() == OthelloBoard.P1) {
			for (Node node : this.grid.getChildren()) {
				Button button = new Button();
				if (this.b.getText() == "Greedy Hint") {
					Move move = p1.getMove();
					if (GridPane.getColumnIndex(node) == move.getCol()) {
						if (GridPane.getRowIndex(node) == move.getRow()) {
							button = (Button) node;
							button.setStyle(p3Colour);
						}
					}
				}
				else if (this.b.getText() == "Random Hint"){
					Move move = p2.getMove();
					if (GridPane.getColumnIndex(node) == move.getCol()) {
						if (GridPane.getRowIndex(node) == move.getRow()) {
							button = (Button) node;
							button.setStyle(p3Colour);
						}
					}
				}
			}
		}
	}

}
