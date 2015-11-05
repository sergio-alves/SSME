package ch.alvisoft.statemachine;

public abstract class Predicate {
	@SuppressWarnings("rawtypes")
	private Input valueToMatch;
	
	@SuppressWarnings("rawtypes")
	public Predicate(Input valueToMatch) {
		this.valueToMatch = valueToMatch;
	}
	
	public abstract boolean match (Input<?> input);
	
	@SuppressWarnings("rawtypes")
	public static Predicate Equals(Input valueToMatch) {
		return new Predicate(valueToMatch) {
			@Override
			public boolean match(Input<?> input) {
				return super.valueToMatch.equals(input);
			}
			
			@Override
			public String toString() {
				return "P:X == " + super.valueToMatch;
			}
		};
	}
	
	@SuppressWarnings("rawtypes")
	public static Predicate And(Input valueToMatch) {
		return new Predicate(valueToMatch) {
			@Override
			public boolean match(Input<?> input) {
				if(super.valueToMatch.getInput() instanceof Boolean && input.getInput() instanceof Boolean) {
					return (Boolean)super.valueToMatch.getInput() && (Boolean)input.getInput();
				}else {
					return false;
				}
			}
			
			@Override
			public String toString() {
				return "P:X && " + super.valueToMatch;
			}
		};
	}
	
	@SuppressWarnings("rawtypes")
	public static Predicate Or(Input valueToMatch) {
		return new Predicate(valueToMatch) {
			@Override
			public boolean match(Input<?> input) {
				if(super.valueToMatch.getInput() instanceof Boolean && input.getInput() instanceof Boolean) {
					return (Boolean)super.valueToMatch.getInput() || (Boolean)input.getInput();
				}else {
					return false;
				}
			}
			
			@Override
			public String toString() {
				return "P:X || " + super.valueToMatch;
			}
		};
	}		
	
	@SuppressWarnings("rawtypes")
	public static Predicate Less (Input valueToMatch) {
		return new Predicate(valueToMatch) {
			@Override
			public boolean match(Input<?> input) {
				if(super.valueToMatch.getInput() instanceof Integer && input.getInput() instanceof Integer) {
					return (Integer)super.valueToMatch.getInput() < (Integer)input.getInput();
				} else {
					return false;
				}
			}
			
			@Override
			public String toString() {
				return "P:X || " + super.valueToMatch;
			}
		};
	}		
}