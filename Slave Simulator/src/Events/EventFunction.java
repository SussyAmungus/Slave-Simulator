package Events;

public interface EventFunction {

	public void PlayEvent();
	
	
	public boolean trigger(int year,int month, int day, int hour, int minute);
	
}
