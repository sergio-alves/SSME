package ch.alvisoft.statemachine;

public class Input <T> {
	private T input;
	
	public Input(T input) {
		this.input = input;
	}
	
	public T getInput() {
		return input;
	}

	public void setInput(T input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return "V:"+input;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Input<?> && ((Input) obj).getInput().equals(input));
	}
}