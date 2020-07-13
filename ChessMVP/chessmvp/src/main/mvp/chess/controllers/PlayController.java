package src.main.mvp.chess.controllers;

import src.main.mvp.chess.models.Error;
import src.main.mvp.chess.models.Game;
import src.main.mvp.chess.models.Piece;
import src.main.mvp.chess.models.State;
import src.main.mvp.chess.models.Turn;

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
