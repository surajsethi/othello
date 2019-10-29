package ca.utoronto.utm.othello.viewcontroller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressEventHandler implements EventHandler<ActionEvent> {
	private int row;
	private int col;
	public ButtonPressEventHandler(int row, int col) {
		this.row = row;
		this.col=col;
	}
	public void handle(ActionEvent event) {
		System.out.println("Row: "+this.row+", Col: "+ this.col);
	}
}
