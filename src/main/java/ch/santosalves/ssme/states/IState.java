package ch.santosalves.ssme.states;

public interface IState {
	public abstract int getId();
	public abstract String getName();
	public abstract Boolean equals(IState actual);
	public abstract String toString();
}