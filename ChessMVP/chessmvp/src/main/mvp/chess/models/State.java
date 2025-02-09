package src.main.mvp.chess.models;

public class State {

    private StateValue stateValue;

    public State() {
        this.reset();
    }

    public void next() {
        assert this.stateValue != StateValue.EXIT;
        this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
    }

    public void reset() {
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }
    
    public void setValueState(StateValue stateValue) {
        this.stateValue = stateValue;
    }
	
}
