package src.main.mvp.chess.views;

import src.main.mvp.utils.Console;

public enum Message {
	TITLE("**********CHESS**********"),
	BLACK_PIECES("Capital Letter Pieces Are Black: "),
	WHITE_PIECES("Small Letter Pieces Are White: "),
	ENTER_POSITION_X1("Enter the position x1: "),
	ENTER_POSITION_Y1("Enter the position y1: "),
	ENTER_POSITION_X2("Enter the position x2: "),
	ENTER_POSITION_Y2("Enter the position y2: "),
	MOVE_SUCCESFULL("Sucessfully moved!!"),
	CHECK("CHECK !! BE CAREFUL"),
	CHECKMATE("CHECKMATE !!!! GAME OVER"),
	EMPTY_SPACE(""),
	PLAY_AGAIN("¿Do you want to play a new game?");
	
	private String message;
	private static Console console = new Console();
	
	private Message(String message) {
		this.message = message;
	}
	
	public void write() {
		Message.console.write(this.message);
	}
	
	public void writeln() {
		Message.console.writeln(this.message);
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
