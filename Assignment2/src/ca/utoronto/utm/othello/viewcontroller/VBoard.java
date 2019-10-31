package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class VBoard extends Label implements Observer {

	private Othello othello;
	private GridPane grid;

	public VBoard(Othello othello, GridPane grid) {
		this.othello = othello;
		this.grid = grid;
	}

	@Override
	public void update(Observable o) {
		for (int row = 0; row < Othello.DIMENSION; row++) {
			for (int col = 0; col < Othello.DIMENSION; col++) {
				Button button = new Button();
				for (Node node : this.grid.getChildren()) {
					if (GridPane.getColumnIndex(node) == col) {
						if (GridPane.getRowIndex(node) == row) {
							button = (Button) node;
							if (this.othello.getToken(row, col) == 'X') {
								button.setText("X");
							}
							if (this.othello.getToken(row, col) == 'O') {
								button.setText("O");
							}
							button.setPrefSize(40, 40);
							button.setOnAction(new ButtonPressEventHandler(row, col, this.othello));
						}
					}
				}
			}
		}
	}

}
