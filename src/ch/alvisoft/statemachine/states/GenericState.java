package ch.alvisoft.statemachine.states;

public class GenericState implements IState{
	private int id;
	private String name;
	
	public GenericState(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public Boolean equals(IState actual) {
		return (actual.getId() == this.id) ;
	}
	
	@Override
	public String toString() {
		return "State(" + id + ", " + name + ")";
	}
}
