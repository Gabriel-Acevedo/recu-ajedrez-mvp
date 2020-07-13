package src.main.mvp.chess.views;

import src.main.mvp.chess.controllers.StartController;

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
