package ca.utoronto.utm.othello.viewcontroller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class OpponentButtonPressEventHandler  implements EventHandler<ActionEvent>  {
	
	private Button b;
	
	@Override
	public void handle(ActionEvent event) {
		this.b = ((Button) (event.getSource()));
		System.out.println(this.b.getText());
		
		
	}

}
