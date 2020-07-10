package src.main.mvc.chess.views;

import src.main.mvc.chess.controllers.StartController;

public class StartView {

	public StartView() {
		super();
	}

	public void interact(StartController startController) {
	        assert startController != null;
	        Message.EMPTY_SPACE.writeln();
	        Message.TITLE.writeln();
	    	Message.BLACK_PIECES.writeln();
	    	Message.WHITE_PIECES.writeln();
	    	Message.EMPTY_SPACE.writeln();
	        startController.start();
	}

	
}
