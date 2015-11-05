package ch.alvisoft.statemachine;

import ch.alvisoft.statemachine.states.IState;

public interface StateChangedListener {
	public void onStateChanged(IState previous, IState current, Input<?> input);
}