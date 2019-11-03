package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.util.Observable;
import ca.utoronto.utm.util.Observer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class VOpponentChooser extends Label implements Observer {
	private FlowPane pane;
	private VBox root;
	
	public VOpponentChooser(FlowPane pane, VBox root) {
		this.pane = pane;
		this.root = root;
	}
	@Override
	public void update(Observable o) {
		//Othello othello = (Othello)o;
		/*
		Button human = new Button("Human");
		human.setOnAction(new OpponentButtonPressEventHandler());
		Button greedy = new Button("Greedy");
		greedy.setOnAction(new OpponentButtonPressEventHandler());
		Button random = new Button("Random");
		random.setOnAction(new OpponentButtonPressEventHandler());
		
		//Label opponent = new Label("Which opponent would you like to play against?");
		
		this.pane.getChildren().addAll(human, greedy, random);
		this.pane.setPrefSize(10, 10);
		this.pane.setVisible(true);	
		this.root.getChildren().add(this.pane);
		*/
	}

}
