package ch.santosalves.ssme;

import ch.santosalves.ssme.states.IState;

public interface StateChangedListener {
	public void onStateChanged(IState previous, IState current, Input<?> input);
}