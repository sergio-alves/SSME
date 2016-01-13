package ch.santosalves.ssme.examples;

import ch.santosalves.ssme.Input;
import ch.santosalves.ssme.StateChangedListener;
import ch.santosalves.ssme.StateMachine;
import ch.santosalves.ssme.Transition;
import static ch.santosalves.ssme.Predicate.Equals;
import ch.santosalves.ssme.states.End;
import ch.santosalves.ssme.states.GenericState;
import ch.santosalves.ssme.states.IState;
import ch.santosalves.ssme.states.Start;

public class TestApp {
	public static void main(String[] args) {
		int startIndex = 0;
		int s1Index = 0;
		int s2Index = 0;
		int endIndex = 0;
		
		StateMachine sm = new StateMachine();		
		startIndex = sm.addState(new Start());	
		s1Index = sm.addState(new GenericState(100, "S1"));
		s2Index = sm.addState(new GenericState(101, "S2"));
		endIndex = sm.addState(new End());

		sm.addListener(new StateChangedListener() {
			@Override
			public void onStateChanged(IState previous, IState current, Input<?> input) {
				System.out.println("State changed from " + previous + " to " + current + " on input " + input );
			}
		});
		
		//(on 1) S->S1
		sm.addTransition(new Transition(sm.getState(startIndex), sm.getState(s1Index), Equals(new Input<Integer>(new Integer(1)))));
		//(on 1) S1->S1
		sm.addTransition(new Transition(sm.getState(s1Index), sm.getState(s1Index), Equals(new Input<Integer>(new Integer(1)))));
		//(on 0) S->S2
		sm.addTransition(new Transition(sm.getState(startIndex), sm.getState(s2Index), Equals(new Input<Integer>(new Integer(0)))));
		//(on 0) S2->S2
		sm.addTransition(new Transition(sm.getState(s2Index), sm.getState(s2Index), Equals(new Input<Integer>(new Integer(0)))));
		//(on 0) S1->S2
		sm.addTransition(new Transition(sm.getState(s1Index), sm.getState(s2Index), Equals(new Input<Integer>(new Integer(0)))));
		//(on 1) S2->E
		sm.addTransition(new Transition(sm.getState(s2Index), sm.getState(endIndex), Equals(new Input<Integer>(new Integer(1)))));
	
	
		//Start		
		String states = "1110001";
		
		for (char c : states.toCharArray()) {
			sm.addInput(new Input<Integer> (Integer.parseInt(String.valueOf(c))));
		}
	}
}
