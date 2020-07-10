package src.main.mvc.chess.views;

import src.main.mvc.chess.controllers.PlayController;
import src.main.mvc.chess.models.Error;

public class PlayView extends SubView{
	
	public PlayView() {
		super();
	}
	
	public void interact(PlayController playController) {
		playController.createBoard();
		playController.showBoard();
		Error error = null;
		
		while(true) {			
			Message.EMPTY_SPACE.writeln();
			System.out.println(playController.getTurn() + " Piece Turn -- ");
			int playerMovements[] = enterMovement();
			try {
				error = playController.isMovePossible(playerMovements);
				if(error != null) {
					console.writeln("");
					console.writeln("Error!! - " + error.name());
					console.writeln("");
				}else {
					playController.movePieceOnBoard(playerMovements);
				}
			}catch(NullPointerException e) {
				Message.EMPTY_SPACE.writeln();
				Error.NO_PIECE_SELECTED.writeln();
				Message.EMPTY_SPACE.writeln();
				
			}
			Message.EMPTY_SPACE.writeln();
			playController.showBoard();
		}		
	}

	
	private int[] enterMovement() {
		int positionX1 = 0;
		int positionY1 = 0;
		int positionX2 = 0;
		int positionY2 = 0;
		positionX1 = this.console.readInt(Message.ENTER_POSITION_X1.getMessage());
		positionY1 = this.console.readInt(Message.ENTER_POSITION_Y1.getMessage());
		positionX2 = this.console.readInt(Message.ENTER_POSITION_X2.getMessage());
		positionY2 = this.console.readInt(Message.ENTER_POSITION_Y2.getMessage());		
		return new int[] {positionX1, positionY1, positionX2, positionY2};
	}
	
}
