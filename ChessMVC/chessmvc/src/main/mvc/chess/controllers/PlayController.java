package src.main.mvc.chess.controllers;

import src.main.mvc.chess.models.Game;
import src.main.mvc.chess.models.Piece;
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
	}

	
	public void createBoard() {
		this.game.createBoard();
	}
	
	public void clearBoard() {
		this.game.clearBoard();
	}
	
	public void showBoard() {
		this.game.showBoard();
	}
	
	public void changeTurn() {
		this.game.changeTurn();
	}
	
	public Turn getTurn() {
		return game.getTurn();
	}
	
	public boolean isKingChecked() {
		return Game.isKingChecked();
	}
	
	public boolean isDefensePossible(int[] playerMovements) {
		return this.game.isDefensePossible(playerMovements);
	}
	
	public boolean isGameFinished() {
		return this.game.isGameFinished();
	}
	
	public void endGame() {
		this.game = new Game();
		this.state.next();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
        assert controllersVisitor != null;
        controllersVisitor.visit(this);	
	}

		
	
}
