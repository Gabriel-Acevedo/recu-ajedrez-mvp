package src.main.mvp.chess.controllers;

import src.main.mvp.chess.models.Game;
import src.main.mvp.chess.models.State;

public class ResumeController extends Controller{

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.state.reset();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        assert controllersVisitor != null;
        controllersVisitor.visit(this);
    }
	
}
