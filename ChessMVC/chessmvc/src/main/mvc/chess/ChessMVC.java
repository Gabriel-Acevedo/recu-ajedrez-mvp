package src.main.mvc.chess;

import src.main.mvc.chess.controllers.Controller;
import src.main.mvc.chess.controllers.Logic;
import src.main.mvc.chess.models.Game;
import src.main.mvc.chess.views.View;

public class ChessMVC {

	private View view;

    private Logic logic;
		
	private ChessMVC() {
		this.view = new View();
        this.logic = new Logic();
	}
		
	
	private void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            if (controller != null) {
                this.view.interact(controller);
            }
        } while (controller != null);
    }
	
	
	public static void main(String arg[]){
		new ChessMVC().play();
	}
	
}
