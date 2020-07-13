package src.main.mvp.chess.controllers;

import java.util.HashMap;
import java.util.Map;

import src.main.mvp.chess.models.Game;
import src.main.mvp.chess.models.State;
import src.main.mvp.chess.models.StateValue;



public class Logic {

	private Game game;
	private State state;
	private Map<StateValue, Controller> controllers;

	public Logic() {
		this.game = new Game();
	    this.state = new State();
	    this.controllers = new HashMap<StateValue, Controller>();
	    this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
	    this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
	    this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
	}
	    
	    
	public Controller getController() {
	    return this.controllers.get(this.state.getValueState());
	}
}
