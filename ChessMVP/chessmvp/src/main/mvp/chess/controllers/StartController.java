package src.main.mvp.chess.controllers;

import src.main.mvp.chess.models.Game;
import src.main.mvp.chess.models.State;
import src.main.mvp.chess.models.StateValue;

public class StartController extends Controller{

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.game = new Game();
        this.state.next();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        assert controllersVisitor != null;
        controllersVisitor.visit(this);
    }

}
