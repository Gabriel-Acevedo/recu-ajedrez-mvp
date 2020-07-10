package src.main.mvc.chess.models;

import src.main.mvc.utils.Console;

public enum Error {
	NO_PIECE_SELECTED("You must select a position that contains a Piece !!"),
	WRONG_POSITION("Invalid move -- Position Not valid !!"),
	ENEMY_PIECE("Invalid Move --Not Your Piece:"),
	ONLY_KING_MOVE_IN_CHECK("You Are In Check. You must move your King.");
	
	private String message;
	private static Console console = new Console();
	
	private Error(String message) {
		this.message = message;
	}
	
	public void write() {
		Error.console.write(this.message);
	}
	
	public void writeln() {
		Error.console.writeln(this.message);
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
