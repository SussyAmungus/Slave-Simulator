
package Main;

import java.util.ArrayList;

import Landmark.LandmarkFunctions;


public class LandmarkManager {
	
	
	GameTimer gt;
	
	ArrayList<LandmarkFunctions> MajorLandList;
	ArrayList<LandmarkFunctions> ReList;

	public LandmarkManager(GameTimer gt) {
		
		this.gt = gt;
		
		MajorLandList = new ArrayList<LandmarkFunctions>();
		
		ReList = new ArrayList<LandmarkFunctions>();
		
		//ReList.add(new PizzaTimeEvent(0, 0, 0, 0, 0));
		
		
	}
	
	
	
	
	public void UpdateEvents() {
		
		int year = gt.getYear();
		int month = gt.getMonth();
		int day = gt.getDay();
		int hour = gt.getHour();
		int minute = gt.getMin();
		
		
		
		for(int i = 0; i < MajorLandList.size(); i++) {
			
			if(MajorLandList.get(i).trigger(year, month, day, hour, minute));
			
			MajorLandList.get(i).PlayEvent();
			
		}
		
		for(int i = 0; i < ReList.size(); i++) {
			
			if(ReList.get(i).trigger(year, month, day, hour, minute));
			
			ReList.get(i).PlayEvent();
			
		}
		
	}
	
	
}
