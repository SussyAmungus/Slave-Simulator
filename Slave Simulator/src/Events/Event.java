package Events;

public abstract class Event {
	
	public int Year;
	public int day;
	public int hour;
	public int minute;
	public int month;
	
	
	public Event(int y, int mo, int d, int h, int m) {
		
		Year = y;
		month = m;
		day = d;
		hour = h;
		minute = mo;
		
		
	}
	
	public boolean trigger(int year,int month, int day, int hour, int minute) {
		
		if(this.Year == year && this.month == month && this.day == day && this.hour == hour && this.minute <= minute) {
			
			return true;
			
			
		}
		return false;
	}
	

	
	
	
}
