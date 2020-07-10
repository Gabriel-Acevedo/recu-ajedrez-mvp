package src.main.mvc.chess.controllers;

import src.main.mvc.chess.models.Game;
import src.main.mvc.chess.models.State;
import src.main.mvc.chess.models.Turn;
import src.main.mvc.chess.models.Error;

public class PlayController extends Controller{

	protected PlayController(Game game, State state) {
		super(game, state);
	}

	public Error isMovePossible(int[] playerMovements) {
		return this.game.isMovePossible(playerMovements);
	}
	
	
	public void movePieceOnBoard(int[] playerMovements) {
		this.game.movePieceOnBoard(playerMovements);
		
		//this.state.next();
	}

	
	public void createBoard() {
		this.game.createBoard();
	}
	
	public void showBoard() {
		this.game.showBoard();
	}
	
	public Turn getTurn() {
		return game.getTurn();
	}
	
	public boolean isKingChecked() {
		return this.game.isKingChecked();
	}
	

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
        assert controllersVisitor != null;
        controllersVisitor.visit(this);	
	}

		
	
}
