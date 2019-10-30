package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressEventHandler implements EventHandler<ActionEvent> {
	private int row;
	private int col;
	private Othello o;
	public ButtonPressEventHandler(int row, int col, Othello othello) {
		this.row = row;
		this.col = col;
		this.o = othello;
	}
	public void handle(ActionEvent event) {
//		System.out.println("Row: "+this.row+", Col: "+ this.col);
		o.move(row, col);
		System.out.println(o.getBoardString());
	}
}
