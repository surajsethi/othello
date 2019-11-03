package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressEventHandler implements EventHandler<ActionEvent> {
	private int row;
	private int col;
	private Othello o;
	// private Button button;

	public ButtonPressEventHandler(int row, int col, Othello othello) {
		this.o = othello;
		this.row = row;
		this.col = col;

	}

	public void handle(ActionEvent event) {
		this.o.move(row, col);

	}
}
