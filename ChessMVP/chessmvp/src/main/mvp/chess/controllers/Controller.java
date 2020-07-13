package src.main.mvp.chess.controllers;

import src.main.mvp.chess.models.Game;
import src.main.mvp.chess.models.State;;


public abstract class Controller {

    protected Game game;
    protected State state;

    protected Controller(Game game, State state) {
        assert game != null;
        assert state != null;
        this.game = game;
        this.state = state;
    }

    abstract public void accept(ControllersVisitor controllersVisitor);
}
