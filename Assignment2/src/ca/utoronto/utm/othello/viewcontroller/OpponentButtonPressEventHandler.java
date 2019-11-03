package ca.utoronto.utm.othello.viewcontroller;

import ca.utoronto.utm.othello.model.Othello;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OpponentButtonPressEventHandler  implements EventHandler<ActionEvent>  {
	private VBox pane;
	private Button b;
	private static Label label;
	
	public OpponentButtonPressEventHandler(VBox p) {
		this.pane = p;
		OpponentButtonPressEventHandler.label = new Label();
		pane.getChildren().addAll(label);
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.b = ((Button) (event.getSource()));
		OpponentButtonPressEventHandler.label.setText("P1:  Human    P2: "+this.b.getText());
		
	}

}
