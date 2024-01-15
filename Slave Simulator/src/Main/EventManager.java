package Main;

import java.util.ArrayList;

import EventList.PizzaTimeEvent;
import Events.EventFunction;


public class EventManager {
	
	
	GameTimer gt;
	
	ArrayList<EventFunction> MajorEventList;
	ArrayList<EventFunction> ReList;

	public EventManager(GameTimer gt) {
		
		this.gt = gt;
		
		MajorEventList = new ArrayList<EventFunction>();
		
		ReList = new ArrayList<EventFunction>();
		
		//ReList.add(new PizzaTimeEvent(0, 0, 0, 0, 0));
		
		
	}
	
	
	
	
	public void UpdateEvents() {
		
		int year = gt.getYear();
		int month = gt.getMonth();
		int day = gt.getDay();
		int hour = gt.getHour();
		int minute = gt.getMin();
		
		
		
		for(int i = 0; i < MajorEventList.size(); i++) {
			
			if(MajorEventList.get(i).trigger(year, month, day, hour, minute));
			
			MajorEventList.get(i).PlayEvent();
			
		}
		
		for(int i = 0; i < ReList.size(); i++) {
			
			if(ReList.get(i).trigger(year, month, day, hour, minute));
			
			ReList.get(i).PlayEvent();
			
		}
		
	}
	
	
}
