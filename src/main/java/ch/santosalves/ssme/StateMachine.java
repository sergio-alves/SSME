package ch.santosalves.ssme;

import java.util.ArrayList;
import java.util.List;

import ch.santosalves.ssme.states.GenericState;
import ch.santosalves.ssme.states.IState;
import ch.santosalves.ssme.states.Start;

public class StateMachine {
	private List<Transition> transitions = new ArrayList<Transition>();
	private List<GenericState> states = new ArrayList<GenericState>();
	private IState current;
	private boolean debug;
	
	private List<StateChangedListener> listeners = new ArrayList<StateChangedListener>();
	
	public void addListener(StateChangedListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(StateChangedListener listener) {
		this.listeners.remove(listener);
	}
	
	public StateMachine() {
		this.debug = false;
	}
	
	public StateMachine(boolean debug) {
		this.debug = debug;
	}
	
	public IState getState(int index) {
		return this.states.get(index);
	}
	
	public int addState(GenericState state) {
		if(state instanceof Start) {
			this.current = state;
		}
		
		this.states.add(state);
		return this.states.indexOf(state);
	}
	
	public void removeState(GenericState state) {
		this.states.remove(state);
	}
	
	public void removeState(int index) {
		this.states.remove(index);
	}
	
	public IState getCurrentState() {
		return this.current;
	}
	
	public void addInput(Input<?> input) {
		IState previous = this.current;
		
		for (Transition transition : this.transitions) {
			if(debug) System.out.println("For input ("+ input +") do we have a transition " + transition);
			
			if(transition.matchTransition(current, input)) {
				this.current = transition.getNextState();				
				for (StateChangedListener listener : this.listeners) {
					listener.onStateChanged(previous, this.current, input);
					return;
				}				
			}
		}
	}
	
	public void addTransition(Transition transition) {
		this.transitions.add(transition);
	}
}
