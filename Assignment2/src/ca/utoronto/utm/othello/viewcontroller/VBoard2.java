package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Label;

/*
 * this view displays the next player and the tokens of both players.s
 */
public class VBoard2 extends Label implements Observer{
	
	@Override
	public void update(Observable o) {
		Othello othello = (Othello)o;
		char next_player = othello.getWhosTurn();
		this.setText(Character.toString(next_player) + " next, "
		+ String.valueOf(othello.getCount(next_player))+" tokens"+"\n"+
				"P1 Count = "+ String.valueOf(othello.getCount(OthelloBoard.P1))+ " "+
				"P2 Count = "+ String.valueOf(othello.getCount(OthelloBoard.P2))+ " "+
				"\n"+ "Winner is"+ " "+ String.valueOf(othello.getWinner()));
	}
}
