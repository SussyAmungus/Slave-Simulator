package Events;

public abstract class Event {
	
	public int Year;
	public int day;
	public int hour;
	public int minute;
	
	public Event(int y,int d, int h, int m) {
		
		Year = y;
		day = d;
		hour = h;
		minute = m;
		
		
	}
	
	public void trigger(int year, int day, int hour, int minute) {
		
		if(this.Year == year && this.day == day && this.hour == hour && this.minute <= minute) {
			
			
			
			
		}
	}
	
	
	public void playEvent() {
		
		
		
		
		
	}
	

}
