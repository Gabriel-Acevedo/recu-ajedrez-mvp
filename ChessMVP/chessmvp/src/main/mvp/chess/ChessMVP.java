package src.main.mvp.chess;

import src.main.mvp.chess.controllers.Controller;
import src.main.mvp.chess.controllers.Logic;
import src.main.mvp.chess.models.Game;
import src.main.mvp.chess.views.View;

public class ChessMVP {

	private View view;

    private Logic logic;
		
	private ChessMVP() {
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
		new ChessMVP().play();
	}
	
}
