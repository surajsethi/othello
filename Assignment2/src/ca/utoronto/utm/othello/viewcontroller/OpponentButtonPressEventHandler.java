package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.othello.model.PlayerGreedy;
import ca.utoronto.utm.othello.model.Move;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OpponentButtonPressEventHandler  implements EventHandler<ActionEvent>  {
	private VBox pane;
	private Button b;
	private static Label label;
	private GridPane grid;
	public String p2Colour = "-fx-background-color: #FFFFFF; ";
	private Othello othello;
	
	public OpponentButtonPressEventHandler(VBox left, GridPane grid, Othello othello) {
		this.pane = left;
		OpponentButtonPressEventHandler.label = new Label();
		//OpponentButtonPressEventHandler.label.setPrefSize(100, 2);
		this.pane.getChildren().addAll(label);
		this.grid = grid;
		this.othello = othello;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.b = ((Button) (event.getSource()));
		
		PlayerGreedy p2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
		
		for (Node node : this.grid.getChildren()) {
			Button button = new Button();
			if (this.b.getText() == "Greedy") {
				Move move = p2.getMove();
				if (GridPane.getColumnIndex(node) == move.getCol()) {
					if (GridPane.getRowIndex(node) == move.getRow()) {
						button = (Button) node;
						button.setStyle(p2Colour);
						this.othello.move(move.getRow(), move.getCol());
					}
				}
			}
		}
		
		OpponentButtonPressEventHandler.label.setText("P1:  Human    P2: "+this.b.getText());		
	}

}
