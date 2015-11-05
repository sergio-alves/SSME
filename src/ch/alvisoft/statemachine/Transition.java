package ch.alvisoft.statemachine;

import ch.alvisoft.statemachine.states.IState;

public class Transition {
	private IState initialState;
	private IState terminalState;
	
	private Predicate predicate;
			
	public IState getNextState() {
		return terminalState;
	}

	public Transition(IState initialState,IState terminalState, Predicate predicate) {
		this.initialState = initialState;
		this.terminalState = terminalState;
		this.predicate = predicate;
	}
	
	public Boolean matchTransition(IState actualState, Input<?> input)  {
		return (actualState.equals(this.initialState) && predicate.match(input));
	}
	
	@Override
	public String toString() {
		return "T:(" + predicate + ", " + initialState + ", " + terminalState +")";
	}
}