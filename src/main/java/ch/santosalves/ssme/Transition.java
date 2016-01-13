package ch.santosalves.ssme;

import ch.santosalves.ssme.states.IState;

public class Transition {
    private final IState initialState;
    private final IState terminalState;
    private final Predicate predicate;

    public IState getNextState() {
        return terminalState;
    }

    public Transition(IState initialState, IState terminalState, Predicate predicate) {
        this.initialState = initialState;
        this.terminalState = terminalState;
        this.predicate = predicate;
    }

    public Boolean matchTransition(IState actualState, Input<?> input) {
        return (actualState.equals(this.initialState) && predicate.match(input));
    }

    @Override
    public String toString() {
        return "T:(" + predicate + ", " + initialState + ", " + terminalState + ")";
    }
}
