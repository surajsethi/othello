package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

/*
 * Whenever the player clicks this button, the game attempt to make a move for that player
 * at this position.
 */
public class ButtonPressEventHandler implements EventHandler<ActionEvent> {
	private int row;
	private int col;
	private Othello o;
	private Label time;
	private Timeline t1;
	private Timeline t2;
	// private Button button;

	public ButtonPressEventHandler(int row, int col, Othello othello, 
			Timeline t1, Timeline t2) {
		this.o = othello;
		this.row = row;
		this.col = col;
		this.t1 = t1;
		this.t2 = t2;

	}

	public void handle(ActionEvent event) {
		this.o.move(row, col);
		t1.setCycleCount(Animation.INDEFINITE);
		t2.setCycleCount(Animation.INDEFINITE);

		
		
		if (this.o.getWhosTurn()== OthelloBoard.P1) {
			
			t1.play();
			t2.stop();
		}
		
		if (this.o.getWhosTurn()== OthelloBoard.P2) {
			t2.play();
			t1.stop();
		}
		
		

	}
}
